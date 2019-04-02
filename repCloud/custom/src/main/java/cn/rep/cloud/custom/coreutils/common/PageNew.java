package cn.rep.cloud.custom.coreutils.common;


import java.io.Serializable;
import java.util.List;

public class PageNew implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * 分页页码
     */
    private int current = 1;
    /**
     * 每页记录数
     */
    private int size = 10;
    /**
     * 总条数
     */
    private int total;
    /**
     * 总页数
     */
    private int pages;
    /**
     * 分页数据
     */
    private List<?> pageList;


    public int getCurrent() {
        return current;
    }

    public void setCurrent(int current) {
        this.current = current;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public List<?> getPageList() {
        return pageList;
    }

    public void setPageList(List<?> pageList) {
        this.pageList = pageList;
    }
}
