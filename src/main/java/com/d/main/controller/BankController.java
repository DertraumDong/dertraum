package com.d.main.controller;
import com.d.main.service.IBankService;
import com.d.main.model.Bank;
import com.d.main.model.BankDTO;
import com.d.main.model.ResultData;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;


/**
* 描述：元数据控制层
* @author Administrator
* @date 2020-04-03 09:46:16
* @version V1.0
*/
@RestController
@RequestMapping("/bank")
public class BankController {

    @Autowired
    private IBankService bankService;

    /**
    * 描述：根据Id 查询
    * @param id  元数据id
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultData findById(@PathVariable("id") String id)throws Exception {
        BankDTO bankDTO = bankService.findDTOById(id);
        return new ResultData(bankDTO);
    }

    /**
    * 描述：根据条件查询User
    * @param bank
    */
    @RequestMapping(value = "/list", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultData selectAll(@RequestBody Bank bank){
        List<Bank> bankList = bankService.selectAll(bank);
        return new ResultData(bankList);
    }

    @PostMapping("/listByCourse")
    public ResultData selectByCourse(@RequestBody Bank bank){
        List<BankDTO> banks = bankService.selectByCourse(bank);
        return new ResultData(banks);
    }

}