package com.d.main.relation.controller;

import com.d.main.relation.model.HumanRelation;
import com.d.main.relation.service.HumanRelationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 2021/2/19
 *
 * @author DerTraum
 * @since 1.0.0
 */
@RestController
@RequestMapping("/relation")
public class HumanRelationController {
    /* 日志记录器 */
    private final static Logger LOGGER = LoggerFactory.getLogger(HumanRelationController.class);

    @Autowired
    private HumanRelationService humanRelationService;

    @PostMapping("/addNewHumanRelation")
    public int addNewHumanRelation(@RequestBody HumanRelation humanRelation){
        return humanRelationService.addNewHumanRelation(humanRelation);
    }
}
