package com.d.main.util;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 名称：
 * 阐述：
 *
 * @author Administrator
 * @date 2020/3/23 18:27
 */
public class RequestApiUtil {

    private static final String DEFAULT_URL = "https://hq.sinajs.cn/list=nf_";

    public static String get(String url,String contractName){
        if(StringUtils.isBlank(url)){
            url = DEFAULT_URL;
        }
        String requestUrl = url + contractName;

        String s = httpRequest(requestUrl);
        return s;
    }

    private static String httpRequest(String requestUrl) {
        //buffer用于接受返回的json数据
        StringBuffer buffer = new StringBuffer();
        try {
            //建立URL，把请求地址给补全，其中urlencode（）方法用于把params里的参数给取出来
            URL url = new URL(requestUrl);
            //打开http连接
            HttpURLConnection httpUrlConnection = (HttpURLConnection) url.openConnection();//连接
            httpUrlConnection.setDoInput(true);
            httpUrlConnection.setRequestMethod("GET");
            httpUrlConnection.connect();

            //获得输入
            InputStream inputStream = httpUrlConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream,"GBK");//编码
            BufferedReader bufferedReader =  new BufferedReader(inputStreamReader);


            //将bufferReader的值给放到str里
            String str = null;
            while((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }


            //关闭bufferReader和输入流
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            // inputStream = null;

            //断开连接
            httpUrlConnection.disconnect();

        } catch(Exception ex) {
            ex.printStackTrace();
        }
        //返回字符串
        return buffer.toString();
    }
}
