package com.d.main.relation.service;

import com.d.main.relation.model.HumanInfo;
import com.d.main.relation.model.HumanRelation;
import com.dtr.web.dto.ResponseVO;

/**
 * 2021/2/19
 *
 * @author DerTraum
 * @since 1.0.0
 */
public interface HumanRelationService {

    ResponseVO queryHumanRelationPage(HumanRelation humanRelation);
}
