package com.d.main.bank.service;

import com.d.main.bank.model.Project;
import com.d.main.bank.model.query.ProjectQuery;
import com.dtr.web.dto.ResponseVO;

/**
 * 名称：
 * 阐述：
 *
 * @author Administrator
 * @date 2021/2/28 11:46
 */
public interface IProjectService {

    ResponseVO queryProjectPage(ProjectQuery projectQuery);
    ResponseVO addProject(Project project);
    ResponseVO deteleProjectById(String id);
}
