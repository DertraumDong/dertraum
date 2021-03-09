package com.d.main.project.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.d.main.project.model.Project;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 名称：
 * 阐述：
 *
 * @author Administrator
 * @date 2021/2/28 11:48
 */
@Component
public interface ProjectDAO extends BaseMapper<Project> {
    List<Project> queryProjectPage(Project project);

    int addProject(Project project);
}