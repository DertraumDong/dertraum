package com.d.main.project.model.dto;

import lombok.Data;

import java.util.Date;

/**
 * @author dertraum
 * @date 2021/3/9 15:09
 */
@Data
public class ProjectDto {

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

    private int view;

}
