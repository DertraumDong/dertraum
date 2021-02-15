package com.d.main.service;

import com.d.main.model.Info;
import com.d.main.model.InfoDTO;
import java.util.List;

/**
* ������合约集合 ����ʵ�ֲ�ӿ�
* @author Administrator
* @date 2020-03-23 06:10:49
*/
public interface IInfoService {

    /**
    * ����������Id��ȡDTO
    * @param id
    */
    InfoDTO findDTOById(String id)throws Exception;

    /**
    * ����������������ѯUser
    * @param info
    */
    public List<Info> selectAll(Info info);

    List<Info> findByType(String type);

}