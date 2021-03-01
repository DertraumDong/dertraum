package com.d.main.relation.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.d.main.relation.model.HumanRelation;
import com.d.main.relation.model.dto.HumanInfoDto;
import com.d.main.relation.model.query.HumanRelationQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 2021/2/20
 *
 * @author DerTraum
 * @since 1.0.0
 */
@Mapper
public interface HumanRelationDao extends BaseMapper {

    int addHumanRelation(HumanRelation humanRelation);

    int deleteByUserId(@Param("userId")String userId);

    List<HumanInfoDto> queryHumanRelationPage(HumanRelationQuery humanRelationQuery);

    int queryHumanRelationPageCount(HumanRelationQuery humanRelationQuery);

}
