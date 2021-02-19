package com.d.main.bank.dao;

import java.util.List;
import com.d.main.bank.model.Contract;
import com.d.main.bank.model.ContractDTO;
import com.d.main.bank.model.ContractResultDTO;
import org.springframework.stereotype.Component;

/**
* ������合约 ����Dao�ӿ�
* @author Administrator
* @date 2020-03-23 05:34:21
*/
@Component
public interface ContractDAO {

    /**
    * ����������Id��ȡDTO
    * @param id
    */
    ContractDTO findDTOById(String id)throws Exception;

    List<Contract> selectAll(Contract contract);

    ContractDTO createContract(ContractDTO contractDTO) throws Exception;

    void deleteContract(String id) throws Exception;

    ContractDTO updateContract(ContractDTO contractDTO) throws Exception;

    int insetContractByValue(List<Contract> contracts);

    int insetContractByValueB(Contract contract);

    List<ContractResultDTO> selectByName(Contract contract);

    List<ContractResultDTO> selectTimeByName(String type);
}