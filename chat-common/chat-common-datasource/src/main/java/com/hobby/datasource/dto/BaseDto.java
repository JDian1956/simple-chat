package com.hobby.datasource.dto;

import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

/**
 * @author Harris
 */
public class BaseDto implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 当前页
     */
    @TableField(exist = false)
    private Integer currentPage;

    /**
     * 每页大小
     */
    @TableField(exist = false)
    private Integer pageSize;

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
