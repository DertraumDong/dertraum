package com.d.main.model;

import java.math.BigDecimal;
import java.util.Date;

/**
* ������元数据ģ��
* @author Administrator
* @date 2020-04-01 02:20:00
*/
public class Metadate extends BaseModel implements java.io.Serializable {

    /**
    *主键id
    */
    private Integer id;
    /**
    *元数据名称
    */
    private String name;
    /**
    *元数据值
    */
    private Long value;


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer Id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getValue() {
        return this.value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

}