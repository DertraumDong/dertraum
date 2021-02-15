package com.d.main.service;

import com.d.main.model.Metadate;
import com.d.main.model.MetadateDTO;
import java.util.List;

/**
* ������元数据 ����ʵ�ֲ�ӿ�
* @author Administrator
* @date 2020-04-01 02:20:00
*/
public interface IMetadateService {

    /**
    * ����������Id��ȡDTO
    * @param id
    */
    MetadateDTO findDTOById(String id)throws Exception;

    /**
    * ����������������ѯUser
    * @param metadate
    */
    public List<Metadate> selectAll(Metadate metadate);

    Integer createMetadate(List<MetadateDTO> list) throws Exception;

    Integer updateMetadate(MetadateDTO metadateDTO) throws Exception;

    void taskVisit() throws Exception;
}