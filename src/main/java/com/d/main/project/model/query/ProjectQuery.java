package com.d.main.project.model.query;

import com.d.main.bank.model.BaseModel;
import lombok.Data;

import java.util.Date;

/**
 * @author dertraum
 * @date 2021/2/28 11:09
 */
@Data
public class ProjectQuery extends BaseModel {

    private String id;

    private String name;

    private String link;

    private String author;

    private String introduce;

    private String creationBy;

    private Date creationDate;

    private String modifyBy;

    private Date modifyDate;

    private int version;

}
