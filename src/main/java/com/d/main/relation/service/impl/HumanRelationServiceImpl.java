package com.d.main.relation.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.d.main.relation.dao.HumanRelationDao;
import com.d.main.relation.model.HumanRelation;
import com.d.main.relation.model.dto.HumanInfoDto;
import com.d.main.relation.model.query.HumanRelationQuery;
import com.d.main.relation.service.HumanRelationService;
import com.dtr.web.dto.ResponseVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public ResponseVO queryHumanRelationPage(HumanRelationQuery humanRelationQuery) {
        ResponseVO responseVO = new ResponseVO();
        Page<HumanInfoDto> page = new Page<>();
        int pageSize = humanRelationQuery.getPageSize();
        int pageNo = humanRelationQuery.getPageNo();
        page.setSize(pageSize);
        page.setCurrent(pageNo);
        humanRelationQuery.setPageNo((pageNo-1)*pageSize);
        humanRelationQuery.setPageSize(humanRelationQuery.getPageSize());
        List<HumanInfoDto> list = this.humanRelationDao.queryHumanRelationPage(humanRelationQuery);
        page.setRecords(list);
        page.setTotal(this.humanRelationDao.queryHumanRelationPageCount(humanRelationQuery));
        responseVO.setData(page);

        return responseVO;
    }
}
