package com.d.main.bank.controller;


import com.d.main.bank.model.Project;
import com.d.main.bank.model.query.ProjectQuery;
import com.d.main.bank.service.IProjectService;
import com.d.main.common.filter.SecurityUtil;
import com.d.main.relation.model.HumanInfo;
import com.dtr.base.dto.BaseExceptionState;
import com.dtr.util.UUIDUtil;
import com.dtr.web.dto.ResponseVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 名称：
 * 阐述：
 *
 * @author Administrator
 * @date 2021/2/28 11:02
 */
@RestController
@RequestMapping("/project")
public class ProjectController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectController.class);

    @Autowired
    private IProjectService projectService;

    @PostMapping("/queryProject")
    public ResponseVO queryProject(@RequestBody ProjectQuery projectQuery){
        ResponseVO responseVO = new ResponseVO();
        try {
            String userId = SecurityUtil.getUserId();
            responseVO = projectService.queryProjectPage(projectQuery);
            return responseVO;
        } catch (Exception e){
            e.printStackTrace();
            responseVO.setCode(BaseExceptionState.COMMON_ERROR.getCode());
            responseVO.setMsg(BaseExceptionState.COMMON_ERROR.getMsg());
            return responseVO;
        }
    }

    @PostMapping("/addProject")
    public ResponseVO addProject(@RequestBody Project project){
        ResponseVO responseVO = new ResponseVO();
        try {
            String userId = SecurityUtil.getUserId();
            project.setAuthor(userId);
            project.setCreationBy(userId);
            project.setModifyBy(userId);
            responseVO = projectService.addProject(project);
            return responseVO;
        } catch (Exception e){
            e.printStackTrace();
            responseVO.setCode(BaseExceptionState.COMMON_ERROR.getCode());
            responseVO.setMsg(BaseExceptionState.COMMON_ERROR.getMsg());
            return responseVO;
        }
    }

    @PostMapping("/deleteProject")
    public ResponseVO deleteProject(@RequestBody Project project){
        ResponseVO responseVO = new ResponseVO();
        try {
            String userId = SecurityUtil.getUserId();
            responseVO = projectService.deteleProjectById(project.getId());
            return responseVO;
        } catch (Exception e){
            e.printStackTrace();
            responseVO.setCode(BaseExceptionState.COMMON_ERROR.getCode());
            responseVO.setMsg(BaseExceptionState.COMMON_ERROR.getMsg());
            return responseVO;
        }
    }
}
