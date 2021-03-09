package com.d.main.project.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.d.main.project.model.ProjectView;
import org.springframework.stereotype.Component;


/**
 * 名称：
 * 阐述：
 *
 * @author Administrator
 * @date 2021/2/28 11:48
 */
@Component
public interface ProjectViewDAO extends BaseMapper<ProjectView> {
    Integer queryProjectViewPageCount();

}