package com.d.main.bank.dao;

import java.util.List;
import com.d.main.bank.model.Bank;
import com.d.main.bank.model.BankDTO;
import org.springframework.stereotype.Component;

/**
* 描述：元数据 服务Dao接口
* @author Administrator
* @date 2020-04-03 09:46:16
*/
@Component
public interface BankDAO {

    /**
    * 描述：根据Id获取DTO
    * @param id
    */
    BankDTO findDTOById(String id)throws Exception;

    List<Bank> selectAll(Bank bank);

    BankDTO createBank(BankDTO bankDTO) throws Exception;

    void deleteBank(String id) throws Exception;

    BankDTO updateBank(BankDTO bankDTO) throws Exception;

    List<BankDTO> selectByCourse(Bank bank);
}