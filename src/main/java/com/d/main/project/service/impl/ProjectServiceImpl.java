package com.d.main.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.d.main.project.dao.ProjectDAO;
import com.d.main.project.model.Project;
import com.d.main.project.model.query.ProjectQuery;
import com.d.main.project.service.IProjectService;
import com.d.main.project.service.ProjectViewService;
import com.dtr.util.UUIDUtil;
import com.dtr.web.dto.ResponseVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * 名称：
 * 阐述：
 *
 * @author Administrator
 * @date 2021/2/28 11:48
 */
@Service
public class ProjectServiceImpl implements IProjectService {
    private static final Logger LOGGER = LoggerFactory.getLogger(ProjectServiceImpl.class);

    @Autowired
    private ProjectDAO projectDAO;
    @Autowired
    private ProjectViewService projectViewService;

    @Override
    public ResponseVO queryProjectPage(ProjectQuery projectQuery) {
        ResponseVO responseVO = new ResponseVO();
        IPage<Project> projectIPage = new Page<>(projectQuery.getPageNo(),projectQuery.getPageSize());
        QueryWrapper<Project> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc("creation_date");
        projectDAO.selectPage(projectIPage,queryWrapper);
        responseVO.setData(projectIPage);

        return responseVO;
    }

    @Override
    public ResponseVO addProject(Project project) {
        ResponseVO responseVO = new ResponseVO();
        String id = UUIDUtil.getUUID();
        project.setId(id);
        project.setCreationDate(new Date());
        project.setModifyDate(new Date());
        project.setVersion(1);
        responseVO.setData(projectDAO.insert(project));
        projectViewService.addProjectView(id);
        return responseVO;
    }

    @Override
    public ResponseVO deteleProjectById(String id) {
        ResponseVO responseVO = new ResponseVO();
        responseVO.setData(projectDAO.deleteById(id));
        projectViewService.deleteProjectView(id);
        return responseVO;
    }
}
