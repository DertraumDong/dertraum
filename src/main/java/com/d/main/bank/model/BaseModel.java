package com.d.main.bank.model;

import lombok.Data;

/**
 * 名称：
 * 阐述：
 *
 * @author Administrator
 * @date 2020/3/23 18:22
 */
@Data
public class BaseModel {
    private String sortName;
    private String sortRule;
    private int pageNo;
    private int pageSize;
    private int totalCount;
}
