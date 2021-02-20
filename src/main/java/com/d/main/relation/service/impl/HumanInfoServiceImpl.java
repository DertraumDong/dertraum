package com.d.main.relation.service.impl;

import com.d.main.relation.dao.HumanInfoDao;
import com.d.main.relation.dao.HumanRelationTypeDao;
import com.d.main.relation.model.HumanInfo;
import com.d.main.relation.model.HumanRelationType;
import com.d.main.relation.service.HumanInfoService;
import com.dtr.util.SnowFlake;
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
    private final static Logger LOGGER = LoggerFactory.getLogger(HumanInfoServiceImpl .class);
    @Autowired
    private HumanInfoDao humanInfoDao;

    @Autowired
    private HumanRelationTypeDao humanRelationTypeDao;

    @Override
    public int addNewHumanRelation(HumanInfo humanInfo) {
        return addNewHuman(humanInfo);
    }

    private int addNewHuman(HumanInfo humanInfo){
        SnowFlake snowFlake = SnowFlake.getSingleobject();
        String humanId = String.valueOf(snowFlake.nextId());
        humanInfo.setHumanId(humanId);
        humanInfo.setCreationBy("ADMIN");
        humanInfo.setCreationDate(new Date());
        humanInfo.setModifyBy("ADMIN");
        humanInfo.setModifyDate(new Date());
        humanInfo.setVersion(0);
        int result = humanInfoDao.addHumanInfo(humanInfo);
        if(result>0){
            List<String> relationTypes = humanInfo.getRelationTypes();
            HashMap<String,String> map = HumanRelationType.getTypeMap();
            List<HumanRelationType> humanRelationTypeList = new ArrayList<>(relationTypes.size());
            for (String type : relationTypes) {
                if(map.containsKey(type)){
                    HumanRelationType humanRelationType = new HumanRelationType();
                    humanRelationType.setHumanId(humanId);
                    humanRelationType.setTagType(type);
                    //humanRelationTypeDao.addBean(humanRelationType);
                    humanRelationTypeList.add(humanRelationType);
                } else {
                    LOGGER.warn(" type is exists : type = {}",type);
                }
            }
            humanRelationTypeDao.batchAdd(humanRelationTypeList);
        }
        return result;
    }
}
