package org.prcode.utility.basic;

/**
 * @ClassName: PageKey
 * @Date: 2017-04-01 14:39
 * @Auther: kangduo
 * @Description: (分页对象)
 */
public class PageKey {
    //页码，从1开始，默认第一页
    public static int page = 1;
    //每页查询数量，默认每页10条
    public static int pageSize = 10;

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
