package com.d.main.project.controller;


import com.d.main.project.model.Project;
import com.d.main.project.model.query.ProjectQuery;
import com.d.main.project.service.IProjectService;
import com.d.main.common.filter.SecurityUtil;
import com.dtr.base.dto.BaseExceptionState;
import com.dtr.web.dto.ResponseVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * project 项目接口
 * 2021/3/9 上午10:20
 * @author derTraum
 * @since 1.0.0
 */
@RestController
@RequestMapping("/project")
public class ProjectController {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectController.class);

    @Autowired
    private IProjectService projectService;

    /**
     * 查询项目接口
     * 2021/3/9 上午10:13
     * @author derTraum
     * @since 1.0.0
     * @param projectQuery projectQuery
     * @return com.dtr.web.dto.ResponseVO
     */
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

    /**
     * 添加项目
     * 2021/3/9 上午10:21
     * @author derTraum
     * @since 1.0.0
     * @param project 项目
     * @return com.dtr.web.dto.ResponseVO
     */
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

    /**
     * 删除项目
     * 2021/3/9 上午10:22
     * @author derTraum
     * @since 1.0.0
     * @param project 项目（id）
     * @return com.dtr.web.dto.ResponseVO
     */
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
