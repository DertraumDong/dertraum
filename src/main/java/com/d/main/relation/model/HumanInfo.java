package com.d.main.relation.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 2021/2/19
 *
 * @author  DerTraum
 * @since 1.0.0
 */
public class HumanInfo implements Serializable {

    private String humanId  ;
    private String humanName  ;
    private Date birthday  ;
    private Date oldBirthday  ;
    private String creationBy  ;
    private Date creationDate  ;
    private String modifyBy  ;
    private Date modifyDate  ;
    private int version;
    private List<String> relationTypes;


    public String getHumanId() {
        return humanId;
    }

    public void setHumanId(String humanId) {
        this.humanId = humanId;
    }

    public String getHumanName() {
        return humanName;
    }

    public void setHumanName(String humanName) {
        this.humanName = humanName;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getOldBirthday() {
        return oldBirthday;
    }

    public void setOldBirthday(Date oldBirthday) {
        this.oldBirthday = oldBirthday;
    }

    public String getCreationBy() {
        return creationBy;
    }

    public void setCreationBy(String creationBy) {
        this.creationBy = creationBy;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(String modifyBy) {
        this.modifyBy = modifyBy;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public List<String> getRelationTypes() {
        return relationTypes;
    }

    public void setRelationTypes(List<String> relationTypes) {
        this.relationTypes = relationTypes;
    }
}
