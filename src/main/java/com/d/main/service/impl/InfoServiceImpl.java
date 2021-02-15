package com.d.main.service.impl;
import com.d.main.model.Info;
import com.d.main.service.IInfoService;
import com.d.main.dao.InfoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.d.main.model.InfoDTO;
import java.util.List;

/**
* ������合约集合 ����ʵ�ֲ�
* @author Administrator
* @date 2020-03-23 06:10:49
*/
@Service
public class InfoServiceImpl implements IInfoService {

    @Autowired
    private InfoDAO infoDAO;

    /**
    * ����������Id��ȡDTO
    * @param id
    */
    @Override
    public InfoDTO findDTOById(String id) throws Exception {
        InfoDTO infoDTO = infoDAO.findDTOById(id);
        return infoDTO;
    }

    /**
    * ����������������ѯUser
    * @param info
    */
    @Override
    public List<Info> selectAll(Info info){
        List<Info> infoList = infoDAO.selectAll(info);
        return infoList;
    }

    @Override
    public List<Info> findByType(String type) {
        return infoDAO.findByType(type);
    }
}

