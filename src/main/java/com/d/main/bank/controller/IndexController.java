package com.d.main.bank.controller;

import com.d.main.bank.model.MetadateDTO;
import com.d.main.bank.service.IMetadateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericToStringSerializer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 名称：
 * 阐述：
 *
 * @author Administrator
 * @date 2020/4/1 11:14
 */
@RestController
@RequestMapping("/index")
public class IndexController {

    private static final String PREFIX_INDEX_STR = "index_data_";
    private static final String[] INDEX_DATA_ARRAY = new String[]{"jinrong","shangcheng","mianshi","github","csdn","leetcode"};

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private IMetadateService iMetadateService;

    /**
     * 首页数据
     * @return
     */
    @GetMapping("/data")
    public Object indexData(){
        redisTemplate.setValueSerializer(new GenericToStringSerializer<Long>(Long.class));
        Map<String,Object> map = new HashMap<>(INDEX_DATA_ARRAY.length);
        for (String str:INDEX_DATA_ARRAY){
            String nstr = PREFIX_INDEX_STR + str;
            map.put(str,redisTemplate.opsForValue().get(nstr));
        }
        return map;
    }

    @GetMapping("/initialize")
    public void initialize() throws Exception {
        List<MetadateDTO> list = new ArrayList<>();
        for (String str : INDEX_DATA_ARRAY){
            MetadateDTO metadateDTO = new MetadateDTO();
            metadateDTO.setName(str);
            metadateDTO.setValue(Long.valueOf(0));
            list.add(metadateDTO);
        }
        MetadateDTO metadateDTO = new MetadateDTO();
        metadateDTO.setName("index_visit_num");
        metadateDTO.setValue(Long.valueOf(0));
        list.add(metadateDTO);
        if(list.size()>0){
            iMetadateService.createMetadate(list);
        }
    }

    @GetMapping("/visit")
    public Object visit(){
        return redisTemplate.opsForValue().increment("index_visit_num");
    }

    @PutMapping("/projectVisit/{str}")
    public Object projectVisit(@PathVariable String str){
        return redisTemplate.opsForValue().increment(PREFIX_INDEX_STR + str);
    }

}
