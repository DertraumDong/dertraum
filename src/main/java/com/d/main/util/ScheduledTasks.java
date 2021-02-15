package com.d.main.util;

import com.d.main.model.Contract;
import com.d.main.model.Info;
import com.d.main.service.IContractService;
import com.d.main.service.IInfoService;
import com.d.main.service.IMetadateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 名称：
 * 阐述：
 *
 * @author Administrator
 * @date 2020/3/23 18:03
 */
@Component
public class ScheduledTasks {

    private static final Logger LOGGER = LoggerFactory.getLogger(ScheduledTasks.class);

    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Autowired
    private IContractService iContractService;

    @Autowired
    private IMetadateService iMetadateService;

    @Scheduled(cron = "0 */50 * * * ?")
    public void taskFutures() throws ParseException {
        iContractService.taskFutures();
    }

    @Scheduled(cron = "0 */60 * * * ?") //每隔60分钟执行一次：
    public void taskMoreFutures() throws ParseException {
        iContractService.taskMoreFutures();
    }

    @Scheduled(cron = "0 */10 * * * ?") //每隔10分钟执行一次：
    public void taskVisit() throws Exception {
        // LOGGER.info("执行定时访问数据更新");
        iMetadateService.taskVisit();
    }
}
