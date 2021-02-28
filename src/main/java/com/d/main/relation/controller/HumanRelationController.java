package com.d.main.relation.controller;

import com.d.main.common.filter.SecurityUtil;
import com.d.main.relation.model.HumanInfo;
import com.d.main.relation.model.HumanRelation;
import com.d.main.relation.model.query.HumanRelationQuery;
import com.d.main.relation.service.HumanRelationService;
import com.dtr.base.dto.BaseExceptionState;
import com.dtr.web.dto.ResponseVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 2021/2/20
 *
 * @author DerTraum
 * @since 1.0.0
 */
@RestController
@RequestMapping("/relation")
public class HumanRelationController {
    /* 日志记录器 */
    private final static Logger LOGGER = LoggerFactory.getLogger(HumanRelationController.class);

    @Autowired
    private HumanRelationService humanRelationService;

    @PostMapping("/queryHumanRelationPage")
    public ResponseVO queryHumanRelationPage(@RequestBody HumanRelationQuery humanRelationQuery){
        ResponseVO responseVO = new ResponseVO();
        try {
            String userId = SecurityUtil.getUserId();
            humanRelationQuery.setUserId(userId);
            responseVO = humanRelationService.queryHumanRelationPage(humanRelationQuery);
            return responseVO;
        } catch (Exception e){
            e.printStackTrace();
            responseVO.setCode(BaseExceptionState.COMMON_ERROR.getCode());
            responseVO.setMsg(BaseExceptionState.COMMON_ERROR.getMsg());
            return responseVO;
        }
    }
}
