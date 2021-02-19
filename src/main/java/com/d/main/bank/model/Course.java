package com.d.main.bank.model;

/**
* 描述：元数据模型
* @author Administrator
* @date 2020-04-03 08:36:26
*/
public class Course extends BaseModel {


    /**
    *主键
    */
    private Integer kid;
    /**
    *分类名称
    */
    private String name;
    /**
    *分类代码
    */
    private String code;


    public Integer getKid() {
        return this.kid;
    }

    public void setKid(Integer kid) {
        this.kid = kid;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return this.code;
    }

    public void setCode(String code) {
        this.code = code;
    }

}