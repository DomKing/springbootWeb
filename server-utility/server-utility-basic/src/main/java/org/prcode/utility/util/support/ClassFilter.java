package org.prcode.utility.util.support;

/**
 * @ClassName: ClassFilter
 * @Date: 2017-4-23 18:17
 * @Auther: https://www.oschina.net/code/snippet_234657_22722
 * @Description: (配合classUtil, 筛选类是否过滤)
 */
public interface ClassFilter {
    boolean accept(Class clazz);
}
