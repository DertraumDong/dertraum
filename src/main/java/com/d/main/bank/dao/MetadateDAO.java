package com.d.main.bank.dao;

import java.util.List;
import com.d.main.bank.model.Metadate;
import com.d.main.bank.model.MetadateDTO;
import org.springframework.stereotype.Component;

/**
* ������元数据 ����Dao�ӿ�
* @author Administrator
* @date 2020-04-01 02:20:00
*/
@Component
public interface MetadateDAO {

    /**
    * ����������Id��ȡDTO
    * @param id
    */
    MetadateDTO findDTOById(String id)throws Exception;

    List<Metadate> selectAll(Metadate metadate);

    Integer createMetadate(List<MetadateDTO> list) throws Exception;

    void deleteMetadate(String id) throws Exception;

    Integer updateMetadate(MetadateDTO metadateDTO) throws Exception;

}