package com.d.main.service.impl;
import com.d.main.model.Metadate;
import com.d.main.service.IMetadateService;
import com.d.main.dao.MetadateDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.stereotype.Service;
import com.d.main.model.MetadateDTO;
import java.util.List;

/**
* ������元数据 ����ʵ�ֲ�
* @author Administrator
* @date 2020-04-01 02:20:00
*/
@Service
public class MetadateServiceImpl implements IMetadateService {

    @Autowired
    private MetadateDAO metadateDAO;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
    * ����������Id��ȡDTO
    * @param id
    */
    @Override
    public MetadateDTO findDTOById(String id) throws Exception {
        MetadateDTO metadateDTO = metadateDAO.findDTOById(id);
        return metadateDTO;
    }

    /**
    * ����������������ѯUser
    * @param metadate
    */
    @Override
    public List<Metadate> selectAll(Metadate metadate){
        List<Metadate> metadateList = metadateDAO.selectAll(metadate);
        return metadateList;
    }

    @Override
    public Integer createMetadate(List<MetadateDTO> list) throws Exception {
        return metadateDAO.createMetadate(list);
    }


    @Override
    public Integer updateMetadate(MetadateDTO metadateDTO) throws Exception {
        return metadateDAO.updateMetadate(metadateDTO);
    }

    @Override
    public void taskVisit() throws Exception {
        redisTemplate.setValueSerializer(new GenericToStringSerializer<Long>(Long.class));
        String str = "index_visit_num";
        MetadateDTO metadateDTO = new MetadateDTO();
        metadateDTO.setName(str);
        Long l = (Long) redisTemplate.opsForValue().get(str);
        metadateDTO.setValue(l);
        metadateDAO.updateMetadate(metadateDTO);
    }
}

