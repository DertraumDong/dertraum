package com.d.main.model;

import java.math.BigDecimal;
import java.util.Date;

/**
* 描述：元数据模型
* @author Administrator
* @date 2020-04-03 09:46:16
*/
public class Bank extends BaseModel {


    /**
    *主键
    */
    private Integer id;
    /**
    *课程分类id
    */
    private Integer kid;
    /**
    *课程分类
    */
    private String course;
    /**
    *题目
    */
    private String title;
    /**
    *内容
    */
    private String content;
    /**
    *创建时间
    */
    private Date createTime;
    /**
    *创建者
    */
    private String creator;
    /**
    *修改时间
    */
    private Date modifyTime;
    /**
    *修改者
    */
    private String modifer;
    /**
    *版本
    */
    private String version;
    /**
    *题的级别
    */
    private String level;


    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getKid() {
        return this.kid;
    }

    public void setKid(Integer kid) {
        this.kid = kid;
    }

    public String getCourse() {
        return this.course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return this.content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return this.createTime;
    }

    public void setCreateTime(Date CreateTime) {
        this.createTime = createTime;
    }

    public String getCreator() {
        return this.creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getModifyTime() {
        return this.modifyTime;
    }

    public void setModifyTime(Date ModifyTime) {
        this.modifyTime = modifyTime;
    }

    public String getModifer() {
        return this.modifer;
    }

    public void setModifer(String modifer) {
        this.modifer = modifer;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getLevel() {
        return this.level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

}