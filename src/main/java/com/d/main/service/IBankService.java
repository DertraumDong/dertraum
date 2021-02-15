package com.d.main.service;

import com.d.main.model.Bank;
import com.d.main.model.BankDTO;
import java.util.List;

/**
* 描述：元数据 服务实现层接口
* @author Administrator
* @date 2020-04-03 09:46:16
*/
public interface IBankService {

    /**
    * 描述：根据Id获取DTO
    * @param id
    */
    BankDTO findDTOById(String id)throws Exception;

    /**
    * 描述：根据条件查询User
    * @param bank
    */
    public List<Bank> selectAll(Bank bank);

    List<BankDTO> selectByCourse(Bank bank);
}