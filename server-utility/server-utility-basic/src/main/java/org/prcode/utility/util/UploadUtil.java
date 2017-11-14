package org.prcode.utility.util;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

/**
 * @className: UploadUtil.
 * @date: 2017-04-25 11:00
 * @author: kangduo
 * @description: (上传文件工具类)
 */
public class UploadUtil {

    /**
     * 上传文件.
     * @param request 请求
     * @param paraName 文件参数名
     * @param baseDir 基本目录
     * @param dir 文件相对目录
     * @return 文件名
     * @throws IOException IO异常
     */
    public static List<String> upload(HttpServletRequest request, String paraName, String baseDir, String dir) throws IOException {
        List<String> fileNames = null;
        if (request instanceof MultipartHttpServletRequest) {
            List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles(paraName);
            fileNames = new ArrayList<>(files.size());
            String originalName;
            String newName;
            for (MultipartFile file : files) {
                if (file.isEmpty()) {
                    continue;
                }
                File dic = new File(baseDir + dir);
                if (!dic.exists()) {
                    dic.mkdirs();
                }
                originalName = file.getOriginalFilename();
                newName = UUIDGenerator.getFileName() + originalName.substring(originalName.lastIndexOf("."));
                Files.copy(file.getInputStream(), Paths.get(baseDir + dir + "/" + newName));
                fileNames.add(dir + "/" + newName);
            }
        }
        return fileNames;
    }

    /**
     * 得到 /year/month.
     * @return 目录
     */
    public static String getMonthDir() {
        Calendar c = Calendar.getInstance();
        return "/" + c.get(Calendar.YEAR) + "/" + (c.get(Calendar.MONTH) + 1);
    }

    /**
     * 得到 /year/month/day.
     * @return 目录
     */
    public static String getDayDir() {
        Calendar c = Calendar.getInstance();
        return "/" + c.get(Calendar.YEAR) + "/" + (c.get(Calendar.MONTH) + 1) + "/" + c.get(Calendar.DAY_OF_MONTH);
    }
}
