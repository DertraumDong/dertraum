package com.d.main.relation.service.impl;

import com.d.main.relation.dao.HumanRelationTypeDao;
import com.d.main.relation.model.HumanInfo;
import com.d.main.relation.model.HumanRelationType;
import com.d.main.relation.service.HumanRelationTypeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

/**
 * 2021/2/20
 *
 * @author DerTraum
 * @since 1.0.0
 */
@Service
public class HumanRelationTypeServiceImpl implements HumanRelationTypeService {

    /* 日志记录器 */
    private final static Logger LOGGER = LoggerFactory.getLogger(HumanRelationTypeServiceImpl.class);

    @Autowired
    private HumanRelationTypeDao humanRelationTypeDao;

    @Override
    public int addHumanRelationType(HumanInfo humanInfo) {
        List<String> relationTypes = humanInfo.getRelationTypes();
        if(CollectionUtils.isEmpty(relationTypes)){
            return 0;
        }
        HashMap<String,String> map = HumanRelationType.getTypeMap();
        List<HumanRelationType> humanRelationTypeList = new ArrayList<>(relationTypes.size());
        String humanId = humanInfo.getHumanId();
        for (String type : relationTypes) {
            if(map.containsKey(type)){
                HumanRelationType humanRelationType = new HumanRelationType();
                humanRelationType.setHumanId(humanId);
                humanRelationType.setTagType(type);
                humanRelationTypeList.add(humanRelationType);
            } else {
                LOGGER.warn(" type is exists : type = {}",type);
            }
        }
        humanRelationTypeDao.deleteByHumanId(humanId);
        return humanRelationTypeDao.batchAdd(humanRelationTypeList);
    }
}
