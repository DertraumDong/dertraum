package com.d.main.bank.service.impl;
import com.d.main.bank.model.Info;
import com.d.main.bank.service.IInfoService;
import com.d.main.bank.dao.InfoDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.d.main.bank.model.InfoDTO;
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

