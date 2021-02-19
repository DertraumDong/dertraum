package com.d.main.bank.model;

/**
 * 名称：
 * 阐述：
 *
 * @author Administrator
 * @date 2020/3/23 18:22
 */
public class BaseModel {
    private String sortName;
    private String sortRule;
    private int pageNo;
    private int pageSize;

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName;
    }

    public String getSortRule() {
        return sortRule;
    }

    public void setSortRule(String sortRule) {
        this.sortRule = sortRule;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
