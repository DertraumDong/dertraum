package com.d.main.model;

import java.math.BigDecimal;
import java.util.Date;

/**
* ������合约集合ģ��
* @author Administrator
* @date 2020-03-23 06:10:49
*/
public class Info extends BaseModel implements java.io.Serializable {

    /**
    *
    */
    private Integer id;
    /**
    *合约
    */
    private String contract;

    private String name;

    public Integer getId() {
        return this.id;
    }

    public void setId(Integer Id) {
        this.id = id;
    }

    public String getContract() {
        return this.contract;
    }

    public void setContract(String Contract) {
        this.contract = Contract;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}