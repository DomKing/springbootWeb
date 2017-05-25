package org.prcode.utility.util;

import org.assertj.core.util.introspection.ClassUtils;
import org.prcode.utility.util.support.ClassFilter;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * @ClassName: ClassUtil
 * @Date: 2017-4-23 18:15
 * @Auther: https://www.oschina.net/code/snippet_234657_22722
 * @Description: (class工具类)
 */
public class ClassUtil {

    private static final String CLASS_EXT = ".class";
    private static final String JAR_FILE_EXT = ".jar";
    private static final String ERROR_MESSAGE = "packageName can't be null";
    private static final String DOT = ".";
    private static final String ZIP_SLASH = "/";
    private static final String BLACK = "";

    /**
     * 文件过滤器，过滤掉不需要的文件
     **/
    private static FileFilter fileFilter = pathname -> isClass(pathname.getName()) || isDirectory(pathname) || isJarFile(pathname.getName());

    /**
     * 如果packageName为空，就抛出空指针异常
     *
     * @param packageName 包名
     */
    private static void ckeckNullPackageName(String packageName) {
        if (packageName == null || packageName.trim().length() == 0)
            throw new NullPointerException(ERROR_MESSAGE);
    }

    /**
     * 改变 com -> com. 避免在比较的时候把比如 completeTestSuite.class类扫描进去，如果没有"."
     * 那么class里面com开头的class类也会被扫描进去,其实名称后面或前面需要一个 ".",来添加包的特征
     *
     * @param packageName 包名
     * @return
     */
    private static String getWellFormedPackageName(String packageName) {
        return packageName.lastIndexOf(DOT) != packageName.length() - 1 ? packageName + DOT : packageName;
    }

    /**
     * 扫面包路径下满足class过滤器条件的所有class文件，</br> 如果包路径为 com.abs + A.class
     * 但是输入 abs 会产生classNotFoundException</br> 因为className 应该为 com.abs.A 现在却成为
     * abs.A,此工具类对该异常进行忽略处理,有可能是一个不完善的地方，以后需要进行修改</br>
     *
     * @param packageName 包路径 com | com. | com.abs | com.abs.
     * @param classFilter class过滤器，过滤掉不需要的class
     * @return
     */
    public static List<Class> scanPackage(String packageName, ClassFilter classFilter) {
        //检测packageName 是否为空，如果为空就抛出NullPointException
        ckeckNullPackageName(packageName);
        //实例化一个篮子 P: 放置class
        final List<Class> classes = new ArrayList<Class>();
        // 遍历在classpath 下面的jar包，class文件夹(现在没有包括 java jre)
        for (String classPath : getClassPathArray()) {
            // 填充 classes
            fillClasses(new File(classPath), getWellFormedPackageName(packageName), classFilter, classes);
        }
        return classes;
    }

    /**
     * 扫面改包路径下所有class文件
     *
     * @param packageName 包路径 com | com. | com.abs | com.abs.
     * @return
     */
    public static List<Class> scanPackage(String packageName) {
        return scanPackage(packageName, null);
    }

    /**
     * 填充满足条件的class 填充到 classes
     *
     * @param file        类路径下的文件
     * @param packageName 需要扫面的包名
     * @param classFilter class过滤器
     * @param classes     List 集合
     */
    private static void fillClasses(File file, String packageName, ClassFilter classFilter, List<Class> classes) {
        if (isDirectory(file)) {
            processDirectory(file, packageName, classFilter, classes);
        } else if (isClass(file.getName())) {
            processClassFile(file, packageName, classFilter, classes);
        } else if (isJarFile(file.getName())) {
            processJarFile(file, packageName, classFilter, classes);
        }
    }

    /**
     * 处理如果为目录的情况,需要递归调用 fillClasses方法
     *
     * @param directory
     * @param packageName
     * @param classFilter
     * @param classes
     */
    private static void processDirectory(File directory, String packageName, ClassFilter classFilter, List<Class> classes) {
        for (File file : directory.listFiles(fileFilter)) {
            fillClasses(file, packageName, classFilter, classes);
        }
    }

    /**
     * 处理为class文件的情况,填充满足条件的class 到 classes
     *
     * @param file
     * @param packageName
     * @param classFilter
     * @param classes
     */
    private static void processClassFile(File file, String packageName, ClassFilter classFilter, List<Class> classes) {
        final String filePathWithDot = file.getAbsolutePath().replace(File.separator, DOT);
        int subIndex = -1;
        if ((subIndex = filePathWithDot.indexOf(packageName)) != -1) {
            final String className = filePathWithDot.substring(subIndex).replace(CLASS_EXT, BLACK);
            fillClass(className, packageName, classes, classFilter);
        }
    }

    /**
     * 处理为jar文件的情况，填充满足条件的class 到 classes
     *
     * @param file
     * @param packageName
     * @param classFilter
     * @param classes
     */
    private static void processJarFile(File file, String packageName, ClassFilter classFilter, List<Class> classes) {
        try {
            for (ZipEntry entry : Collections.list(new ZipFile(file).entries())) {
                if (isClass(entry.getName())) {
                    final String className = entry.getName().replace(ZIP_SLASH, DOT).replace(CLASS_EXT, BLACK);
                    fillClass(className, packageName, classes, classFilter);
                }
            }
        } catch (Throwable ex) {
            // ignore this ex
        }
    }

    /**
     * 填充class 到 classes
     *
     * @param className
     * @param packageName
     * @param classes
     * @param classFilter
     */
    private static void fillClass(String className, String packageName, List<Class> classes, ClassFilter classFilter) {
        if (checkClassName(className, packageName)) {
            try {
                final Class clazz = Class.forName(className, Boolean.FALSE, ClassUtils.class.getClassLoader());
                if (checkClassFilter(classFilter, clazz)) {
                    classes.add(clazz);
                }
            } catch (Throwable ex) {
                // ignore this ex
            }
        }
    }

    private static String[] getClassPathArray() {
        //不包括 jre
        return System.getProperty("java.class.path").split(System.getProperty("path.separator"));
    }

    private static boolean checkClassName(String className, String packageName) {
        return className.indexOf(packageName) == 0;
    }

    private static boolean checkClassFilter(ClassFilter classFilter, Class clazz) {
        return classFilter == null || classFilter.accept(clazz);
    }

    private static boolean isClass(String fileName) {
        return fileName.endsWith(CLASS_EXT);
    }

    private static boolean isDirectory(File file) {
        return file.isDirectory();
    }

    private static boolean isJarFile(String fileName) {
        return fileName.endsWith(JAR_FILE_EXT);
    }
}
