package com.tickets.Tickets.entity;

import java.io.Serializable;
//分页辅助类
public class PageDto implements Serializable {
    private static final long serialVersionUID = -3166444663071519405L;
    private int total_rows; //总记录数 可以查
    private int current_page; //当前页 传递过来的
    private int page_size; //每页条数 应该是有的  可以定义

    private int total_pages; //总页数   可以算
    private int offset_row; //偏移量  可以算
    private boolean hasPrev; //是否有前一页  可以算
    private boolean hasNext; //是否有下一页 可算

    // select * from t_emp limit m , n ;   m--从哪里开始查      n-- 差多少条记录  就是 page_size
    public PageDto(int total_rows, int current_page, int page_size) {
        super();
        this.total_rows = total_rows;
        this.current_page = current_page;
        this.page_size = page_size;

        this.total_pages = this.total_rows % this.page_size == 0 ? this.total_rows / this.page_size : this.total_rows / this.page_size + 1;
        this.offset_row = (this.current_page - 1) * this.page_size;
        this.hasPrev = this.current_page == 1 ? false : true;
        this.hasNext = this.total_pages == this.current_page ? false : true;
    }

    public int getTotal_rows() {
        return total_rows;
    }

    public void setTotal_rows(int total_rows) {
        this.total_rows = total_rows;
    }

    public int getCurrent_page() {
        return current_page;
    }

    public void setCurrent_page(int current_page) {
        this.current_page = current_page;
    }

    public int getPage_size() {
        return page_size;
    }

    public void setPage_size(int page_size) {
        this.page_size = page_size;
    }

    public int getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(int total_pages) {
        this.total_pages = total_pages;
    }

    public int getOffset_row() {
        return offset_row;
    }

    public void setOffset_row(int offset_row) {
        this.offset_row = offset_row;
    }

    public boolean isHasPrev() {
        return hasPrev;
    }

    public void setHasPrev(boolean hasPrev) {
        this.hasPrev = hasPrev;
    }

    public boolean isHasNext() {
        return hasNext;
    }

    public void setHasNext(boolean hasNext) {
        this.hasNext = hasNext;
    }

    @Override
    public String toString() {
        return "PageDto [total_rows=" + total_rows + ", current_page=" + current_page + ", page_size=" + page_size
                + ", total_pages=" + total_pages + ", offset_row=" + offset_row + ", hasPrev=" + hasPrev + ", hasNext="
                + hasNext + "]";
    }

}

