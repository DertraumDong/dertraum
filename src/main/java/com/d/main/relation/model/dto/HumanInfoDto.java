package com.d.main.relation.model.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 2021/2/20
 *
 * @author DerTraum
 * @since 1.0.0
 */
public class HumanInfoDto implements Serializable {
    private String userId;
    private String humanId;
    private String humanName;
    private Date birthday;
    private Date oldBirthday;
    private Date creationDate;
    private List<String> types;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public List<String> getTypes() {
        return types;
    }

    public void setTypes(List<String> types) {
        this.types = types;
    }
}
