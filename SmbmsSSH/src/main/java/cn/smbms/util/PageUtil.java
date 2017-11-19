package cn.smbms.util;

import java.util.List;

/**
 * Created by Administrator on 2017/11/11.
 * 分页工具类
 */
public class PageUtil<T> {
    private Integer pageIndex;  //当前页索引
    private Integer pageSize;  //每页显示的记录数
    private Integer totalRecords;  //总记录数
    private Integer totalPages;  //总页数
    private List<T> list;

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(Integer totalRecords) {
        this.totalRecords = totalRecords;
    }

    public Integer getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
