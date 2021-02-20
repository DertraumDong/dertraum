package com.d.main.relation.dao;

import com.d.main.relation.model.HumanInfo;
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
public interface HumanInfoDao {
    List<HumanInfo> findDTOByName(@Param("humanName") String humanName);

    int addHumanInfo(HumanInfo humanInfo);
}
