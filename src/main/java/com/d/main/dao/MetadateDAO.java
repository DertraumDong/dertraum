package com.d.main.dao;

import java.util.List;
import com.d.main.model.Metadate;
import com.d.main.model.MetadateDTO;
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