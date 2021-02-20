package com.d.main.common.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 2021/2/20
 *
 * @author DerTraum
 * @since 1.0.0
 */
@Component
public class SecurityUtil {
    /* 日志记录器 */
    private final static Logger LOGGER = LoggerFactory.getLogger(SecurityUtil.class);

    private static boolean debug;

    private static String userId;

    private static SecurityUtil securityUtil;

    static{
        Properties props = new Properties();
        InputStream in = SecurityUtil.class.getClassLoader().getResourceAsStream("application-test.yml");
        if (in == null) {
            throw new RuntimeException("配置文件不存在");
        }
        try {
            props.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        debug = Boolean.parseBoolean(props.getProperty("isDebug"));
        if(debug){
            userId = props.getProperty("userId");
            LOGGER.info("SecurityUtil ==> debug is true, userId = {}",userId);
        }else{
            LOGGER.info("SecurityUtil ==> debug is false");
        }
    }

    public static String getUserId(){
        return userId;
    }
}
