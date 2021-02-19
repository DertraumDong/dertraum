package com.d.main.bank.util;

import com.d.main.bank.service.IContractService;
import com.d.main.bank.service.IMetadateService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;

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
