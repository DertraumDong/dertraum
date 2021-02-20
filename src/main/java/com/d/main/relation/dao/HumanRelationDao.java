package com.d.main.relation.dao;

import com.d.main.relation.model.HumanRelation;
import com.d.main.relation.model.dto.HumanInfoDto;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 2021/2/20
 *
 * @author DerTraum
 * @since 1.0.0
 */
@Component
public interface HumanRelationDao {

    int addHumanRelation(HumanRelation humanRelation);

    int deleteByUserId(@Param("userId")String userId);

    List<HumanInfoDto> queryHumanRelationPage(HumanRelation humanRelation);

}
