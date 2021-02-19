package com.d.main.relation.dao;

import com.d.main.relation.model.HumanRelation;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 2021/2/19
 *
 * @author DerTraum
 * @since 1.0.0
 */
@Component
public interface HumanRelationDao {
    List<HumanRelation> findDTOById(@Param("humanId") String humanId);

    int addBean(HumanRelation humanRelation);
}
