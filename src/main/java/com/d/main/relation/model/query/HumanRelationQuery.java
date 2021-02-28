package com.d.main.relation.model.query;

import com.d.main.bank.model.BaseModel;

import java.util.Date;

/**
 * 2021/2/20
 *
 * @author DerTraum
 * @since 1.0.0
 */
public class HumanRelationQuery extends BaseModel {
    private String userId;
    private String humanId;
    private Date creationDate;

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

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
