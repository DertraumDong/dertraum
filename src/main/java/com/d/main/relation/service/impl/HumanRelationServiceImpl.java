package com.d.main.relation.service.impl;

import com.d.main.relation.dao.HumanRelationDao;
import com.d.main.relation.model.HumanInfo;
import com.d.main.relation.model.HumanRelation;
import com.d.main.relation.service.HumanRelationService;
import com.dtr.web.dto.ResponseVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 2021/2/20
 *
 * @author DerTraum
 * @since 1.0.0
 */
@Service
public class HumanRelationServiceImpl implements HumanRelationService {
    /* 日志记录器 */
    private final static Logger LOGGER = LoggerFactory.getLogger(HumanRelationServiceImpl.class);

    @Autowired
    private HumanRelationDao humanRelationDao;

    @Override
    public ResponseVO queryHumanRelationPage(HumanRelation humanRelation) {
        ResponseVO responseVO = new ResponseVO();
        responseVO.setData(humanRelationDao.queryHumanRelationPage(humanRelation));
        return responseVO;
    }
}
