package com.d.main.dao;

import java.util.List;
import com.d.main.model.Info;
import com.d.main.model.InfoDTO;
import org.springframework.stereotype.Component;

/**
* ������合约集合 ����Dao�ӿ�
* @author Administrator
* @date 2020-03-23 06:10:49
*/
@Component
public interface InfoDAO {

    /**
    * ����������Id��ȡDTO
    * @param id
    */
    InfoDTO findDTOById(String id)throws Exception;

    List<Info> selectAll(Info info);

    InfoDTO createInfo(InfoDTO infoDTO) throws Exception;

    void deleteInfo(String id) throws Exception;

    InfoDTO updateInfo(InfoDTO infoDTO) throws Exception;

    List<Info> findByType(String type);


}