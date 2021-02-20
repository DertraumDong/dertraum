package com.d.main.relation.service.impl;

import com.d.main.relation.dao.HumanInfoDao;
import com.d.main.relation.dao.HumanRelationDao;
import com.d.main.relation.dao.HumanRelationTypeDao;
import com.d.main.relation.model.HumanInfo;
import com.d.main.relation.model.HumanRelation;
import com.d.main.relation.model.HumanRelationType;
import com.d.main.relation.service.HumanInfoService;
import com.d.main.relation.service.HumanRelationTypeService;
import com.dtr.base.dto.BaseExceptionState;
import com.dtr.util.SnowFlake;
import com.dtr.web.dto.ResponseVO;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * 2021/2/19
 *
 * @author DerTraum
 * @since 1.0.0
 */
@Service
public class HumanInfoServiceImpl implements HumanInfoService {
    /* 日志记录器 */
    private final static Logger LOGGER = LoggerFactory.getLogger(HumanInfoServiceImpl.class);

    @Autowired
    private HumanInfoDao humanInfoDao;
    @Autowired
    private HumanRelationDao humanRelationDao;
    @Autowired
    private HumanRelationTypeService humanRelationTypeService;

    @Override
    public ResponseVO addNewHumanRelation(HumanInfo humanInfo) {
        return addNewHuman(humanInfo);
    }

    private ResponseVO addNewHuman(HumanInfo humanInfo){
        ResponseVO responseVO = new ResponseVO();
        SnowFlake snowFlake = SnowFlake.getSingleobject();
        String humanId = String.valueOf(snowFlake.nextId());
        humanInfo.setHumanId(humanId);
        humanInfo.setCreationDate(new Date());
        humanInfo.setModifyDate(new Date());
        humanInfo.setVersion(0);
        int result = humanInfoDao.addHumanInfo(humanInfo);
        if(result>0){
            HumanRelation humanRelation = new HumanRelation();
            humanRelation.setUserId(humanInfo.getCreationBy());
            humanRelation.setHumanId(humanId);
            humanRelation.setCreationDate(new Date());
            humanRelationDao.addHumanRelation(humanRelation);
            humanRelationTypeService.addHumanRelationType(humanInfo);
        }
        responseVO.setData(humanId);
        return responseVO;
    }

    @Override
    public ResponseVO updateHumanRelation(HumanInfo humanInfo) {
        ResponseVO responseVO = new ResponseVO();
        String humanId = humanInfo.getHumanId();
        if(StringUtils.isBlank(humanId)){
            responseVO.setCode(BaseExceptionState.COMMON_ERROR.getCode());
            responseVO.setMsg("id is empty");
            return responseVO;
        }
        HumanInfo resultHumanInfo = humanInfoDao.findDTOByHumanId(humanId);
        if(resultHumanInfo == null){
            responseVO.setCode(BaseExceptionState.COMMON_ERROR.getCode());
            responseVO.setMsg("id is not exists");
            return responseVO;
        }
        int result = humanInfoDao.updateByHumanId(humanInfo);
        if(result>0){
            humanRelationTypeService.addHumanRelationType(humanInfo);
        }
        responseVO.setData(result);
        return responseVO;
    }
}
