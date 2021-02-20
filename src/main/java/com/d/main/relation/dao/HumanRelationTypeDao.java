package com.d.main.relation.dao;

import com.d.main.relation.model.HumanRelationType;
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
public interface HumanRelationTypeDao {
    int addBean(HumanRelationType humanRelationType);

    int batchAdd(@Param("list") List<HumanRelationType> humanRelationType);

    int deleteByHumanId(@Param("humanId")String humanId);
}
