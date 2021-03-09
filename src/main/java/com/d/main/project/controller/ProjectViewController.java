package com.d.main.project.controller;

import com.d.main.common.filter.SecurityUtil;
import com.d.main.project.service.ProjectViewService;
import com.dtr.base.dto.BaseExceptionState;
import com.dtr.web.dto.ResponseVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 2021/3/9
 *
 * @author DerTraum
 * @since 1.0.0
 */
@RestController
@RequestMapping("/projectView")
public class ProjectViewController {
    /* 日志记录器 */
    private final static Logger LOGGER = LoggerFactory.getLogger(ProjectViewController.class);

    @Autowired
    private ProjectViewService projectViewService;

    /**
     * 查询项目的访问数，主要是从缓存中查询
     * 2021/3/9 上午10:22
     * @author derTraum
     * @since 1.0.0
     * @return com.dtr.web.dto.ResponseVO
     */
    @GetMapping("/queryProjectView")
    public ResponseVO queryProjectView(){
        ResponseVO responseVO = new ResponseVO();
        try {
            String userId = SecurityUtil.getUserId();
            responseVO = projectViewService.queryAllProjectView();
            return responseVO;
        } catch (Exception e){
            e.printStackTrace();
            responseVO.setCode(BaseExceptionState.COMMON_ERROR.getCode());
            responseVO.setMsg(BaseExceptionState.COMMON_ERROR.getMsg());
            return responseVO;
        }
    }

    @GetMapping("/visitProject/{id}")
    public ResponseVO visitProjectView(@PathVariable("id") String id){
        ResponseVO responseVO = new ResponseVO();
        projectViewService.visitProject(id);
        return responseVO;
    }
}
