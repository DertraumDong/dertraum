package com.d.main.controller;
import com.d.main.service.IInfoService;
import com.d.main.model.Info;
import com.d.main.model.InfoDTO;
import com.d.main.model.ResultData;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;


/**
* ������合约集合���Ʋ�
* @author Administrator
* @date 2020-03-23 06:10:49
* @version V1.0
*/
@RestController
@RequestMapping("/info")
public class InfoController {

    @Autowired
    private IInfoService infoService;

    /**
    * ����������Id ��ѯ
    * @param id  合约集合id
    */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultData findById(@PathVariable("id") String id)throws Exception {
        InfoDTO infoDTO = infoService.findDTOById(id);
        return new ResultData(infoDTO);
    }

    /**
    * ����������������ѯUser
    * @param info
    */
    @RequestMapping(value = "/list", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResultData selectAll(@RequestBody Info info){
        List<Info> infoList = infoService.selectAll(info);
        return new ResultData(infoList);
    }

}