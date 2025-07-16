package com.hobby.datasource.utils;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * @author Harris
 */
public class PageResponse<T> {
    private List<T> records;
    private long total;
    private long size;
    private long current;
    private long pages;

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public long getCurrent() {
        return current;
    }

    public void setCurrent(long current) {
        this.current = current;
    }

    public long getPages() {
        return pages;
    }

    public void setPages(long pages) {
        this.pages = pages;
    }

    public static <T> PageResponse<T> of(Page<T> page) {
        PageResponse<T> pageResponse = new PageResponse<>();
        pageResponse.setRecords(page.getRecords());
        pageResponse.setTotal(page.getTotal());
        pageResponse.setSize(page.getSize());
        pageResponse.setCurrent(page.getCurrent());
        pageResponse.setPages(page.getPages());
        return pageResponse;
    }

    public static <T, R> PageResponse<R> of(Page<T> page, List<R> records) {
        PageResponse<R> pageResponse = new PageResponse<>();
        pageResponse.setRecords(records);
        pageResponse.setTotal(page.getTotal());
        pageResponse.setSize(page.getSize());
        pageResponse.setCurrent(page.getCurrent());
        pageResponse.setPages(page.getPages());
        return pageResponse;
    }
}
