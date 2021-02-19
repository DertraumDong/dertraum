package com.d.main.bank.controller;
import com.d.main.bank.model.*;
import com.d.main.bank.service.IContractService;

import java.text.ParseException;
import java.util.*;

import com.d.main.bank.service.IInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;


/**
* ������合约���Ʋ�
* @author Administrator
* @date 2020-03-23 05:34:21
* @version V1.0
*/
@RestController
@RequestMapping("/contract")
public class ContractController {

    @Autowired
    private IContractService iContractService;

    @Autowired
    private IInfoService iInfoService;

    /**
    * ����������Id ��ѯ
    * @param id  合约id
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultData findById(@PathVariable("id") String id)throws Exception {
        ContractDTO contractDTO = iContractService.findDTOById(id);
        return new ResultData(contractDTO);
    }

    /**
    * ����������������ѯUser
    * @param contract
    */
    @RequestMapping(value = "/list", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultData selectAll(@RequestBody Contract contract){
        List<Contract> contractList = iContractService.selectAll(contract);
        return new ResultData(contractList);
    }

    /**
     *
     * @param name
     * @return
     */
    @PostMapping("/findByName")
    public Object selectByName(@RequestParam String name) throws ParseException {
        Contract contract = new Contract();
        contract.setName(name);
        List<ContractResultDTO> list = iContractService.selectByName(contract);
        return list;
    }

    /**
     *
     * @param type
     * @return
     */
    @PostMapping("/findByContractType")
    public Object selectContractAll(@RequestParam String type){
        List<Info> infoList = iInfoService.findByType(type);
        Map<String,Object> map = new HashMap<>();
        map.put("info" , infoList);
        for(Info info : infoList){
            Contract contract = new Contract();
            String name = info.getName();
            contract.setName(name);
            List<ContractResultDTO> contractList = iContractService.selectByName(contract);
            map.put(name , contractList);
        }
        List<ContractResultDTO> contractList = iContractService.selectTimeByName(type);
        map.put("time",contractList);
        return map;
    }
}