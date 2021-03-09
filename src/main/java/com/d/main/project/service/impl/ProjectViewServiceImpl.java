package com.d.main.project.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.d.main.project.dao.ProjectViewDAO;
import com.d.main.project.model.ProjectView;
import com.d.main.project.service.ProjectViewService;
import com.dtr.web.dto.ResponseVO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * 2021/3/9
 *
 * @author DerTraum
 * @since 1.0.0
 */
@Service
public class ProjectViewServiceImpl implements ProjectViewService {
    /* 日志记录器 */
    private final static Logger LOGGER = LoggerFactory.getLogger(ProjectViewServiceImpl.class);

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private ProjectViewDAO projectViewDAO;

    private static final String PROJECT_VIEW_KEY = "PROJECT_VIEW_KEY";
    private static final int PAGESIZE = 30;
    @Override
    public ResponseVO queryAllProjectView() {
        ResponseVO responseVO = new ResponseVO();
        Map<String,Integer> map = new HashMap<>();
        // 查询是否存在缓存
        if(redisTemplate.hasKey(PROJECT_VIEW_KEY)){
            map = redisTemplate.opsForHash().entries(PROJECT_VIEW_KEY);
            responseVO.setData(map);
            return responseVO;
        }
        // 假如缓存失效或者不存在，那么从数据库初始化到缓存中
        int count = projectViewDAO.queryProjectViewPageCount();
        int pageNoCount = Math.max(count / PAGESIZE, 1);
        int pageNo = 1;
        List<ProjectView> resultList = new ArrayList<>(PAGESIZE);
        while (pageNo<=pageNoCount){
            IPage<ProjectView> projectIPage = new Page<>(pageNo,PAGESIZE);
            QueryWrapper<ProjectView> queryWrapper = new QueryWrapper<>();
            projectViewDAO.selectPage(projectIPage,queryWrapper);
            resultList.addAll(projectIPage.getRecords());
            pageNo++;
        }
        Map<String,Integer> resultMap = new HashMap<>();
        resultList.forEach(projectView -> {
            resultMap.put(projectView.getId(),projectView.getViews());
        });
        redisTemplate.opsForHash().putAll(PROJECT_VIEW_KEY,resultMap);
        responseVO.setData(resultMap);
        return responseVO;
    }

    @Override
    public int addProjectView(String id) {
        if(StringUtils.isBlank(id)){
            throw new RuntimeException("add projectView : id is empty;");
        }
        ProjectView resultProjectView = projectViewDAO.selectById(id);
        if(resultProjectView!=null){
            throw new RuntimeException("add projectView : id is exists;");
        }
        ProjectView projectView = new ProjectView();
        projectView.setId(id);
        projectView.setViews(0);
        return projectViewDAO.insert(projectView);
    }

    @Override
    public int deleteProjectView(String id) {
        if(StringUtils.isBlank(id)){
            throw new RuntimeException("delete projectView : id is empty;");
        }
        return projectViewDAO.deleteById(id);
    }

    @Override
    public void visitProject(String id) {
        redisTemplate.opsForHash().increment(PROJECT_VIEW_KEY,id,1);
    }


}
