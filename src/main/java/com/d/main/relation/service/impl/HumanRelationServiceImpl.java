package com.d.main.relation.service.impl;

import com.d.main.relation.dao.HumanRelationDao;
import com.d.main.relation.model.HumanRelation;
import com.d.main.relation.service.HumanRelationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

/**
 * 2021/2/19
 *
 * @author DerTraum
 * @since 1.0.0
 */
@Service
public class HumanRelationServiceImpl implements HumanRelationService {

    @Autowired
    private HumanRelationDao humanRelationDao;
    @Override
    public int addNewHumanRelation(HumanRelation humanRelation) {
        String humanId = UUID.randomUUID().toString().replaceAll("-","");
        humanRelation.setHumanId(humanId);
        humanRelation.setCreationBy("ADMIN");
        humanRelation.setCreationDate(new Date());
        humanRelation.setModifyBy("ADMIN");
        humanRelation.setModifyDate(new Date());
        humanRelation.setVersion(0);
        return humanRelationDao.addBean(humanRelation);
    }
}
