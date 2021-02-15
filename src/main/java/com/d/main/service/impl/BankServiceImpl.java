package com.d.main.service.impl;
import com.d.main.model.Bank;
import com.d.main.service.IBankService;
import com.d.main.dao.BankDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.d.main.model.BankDTO;
import java.util.List;

/**
* 描述：元数据 服务实现层
* @author Administrator
* @date 2020-04-03 09:46:16
*/
@Service
public class BankServiceImpl implements IBankService {

    @Autowired
    private BankDAO bankDAO;

    /**
    * 描述：根据Id获取DTO
    * @param id
    */
    @Override
    public BankDTO findDTOById(String id) throws Exception {
        BankDTO bankDTO = bankDAO.findDTOById(id);
        return bankDTO;
    }

    /**
    * 描述：根据条件查询User
    * @param bank
    */
    @Override
    public List<Bank> selectAll(Bank bank){
        List<Bank> bankList = bankDAO.selectAll(bank);
        return bankList;
    }

    @Override
    public List<BankDTO> selectByCourse(Bank bank) {
        return bankDAO.selectByCourse(bank);
    }
}

