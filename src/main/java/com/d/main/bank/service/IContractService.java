package com.d.main.bank.service;

import com.d.main.bank.model.Contract;
import com.d.main.bank.model.ContractDTO;
import com.d.main.bank.model.ContractResultDTO;

import java.text.ParseException;
import java.util.List;

/**
* ������合约 ����ʵ�ֲ�ӿ�
* @author Administrator
* @date 2020-03-23 05:34:21
*/
public interface IContractService {

    /**
    * ����������Id��ȡDTO
    * @param id
    */
    ContractDTO findDTOById(String id)throws Exception;

    /**
    * ����������������ѯUser
    * @param contract
    */
    public List<Contract> selectAll(Contract contract);

    int insetContractByValue(List<Contract> contracts);

    int insetContractByValueB(Contract contract);

    List<ContractResultDTO> selectByName(Contract contract);

    List<ContractResultDTO> selectTimeByName(String type);

    public void taskFutures() throws ParseException;

    public void taskMoreFutures() throws ParseException;
}