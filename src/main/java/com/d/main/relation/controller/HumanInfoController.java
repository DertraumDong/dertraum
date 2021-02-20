package com.d.main.relation.controller;

import com.d.main.common.filter.SecurityUtil;
import com.d.main.relation.model.HumanInfo;
import com.d.main.relation.service.HumanInfoService;
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
 * 2021/2/19
 *
 * @author DerTraum
 * @since 1.0.0
 */
@RestController
@RequestMapping("/relation")
public class HumanInfoController {
    /* 日志记录器 */
    private final static Logger LOGGER = LoggerFactory.getLogger(HumanInfoController.class);

    @Autowired
    private HumanInfoService humanInfoService;

    @PostMapping("/addNewHumanRelation")
    public ResponseVO addNewHumanRelation(@RequestBody HumanInfo humanInfo){
        ResponseVO responseVO = new ResponseVO();
        try {
            String userId = SecurityUtil.getUserId();
            humanInfo.setCreationBy(userId);
            humanInfo.setModifyBy(userId);
            return humanInfoService.addNewHumanRelation(humanInfo);
        } catch (Exception e){
            e.printStackTrace();
            responseVO.setCode(BaseExceptionState.COMMON_ERROR.getCode());
            responseVO.setMsg(BaseExceptionState.COMMON_ERROR.getMsg());
            return responseVO;
        }
    }

    @PostMapping("/updateHumanRelation")
    public ResponseVO updateHumanRelation(@RequestBody HumanInfo humanInfo){
        ResponseVO responseVO = new ResponseVO();
        try {
            String userId = SecurityUtil.getUserId();
            humanInfo.setModifyBy(userId);
            responseVO = humanInfoService.updateHumanRelation(humanInfo);
            return responseVO;
        } catch (Exception e){
            e.printStackTrace();
            responseVO.setCode(BaseExceptionState.COMMON_ERROR.getCode());
            responseVO.setMsg(BaseExceptionState.COMMON_ERROR.getMsg());
            return responseVO;
        }
    }
}
