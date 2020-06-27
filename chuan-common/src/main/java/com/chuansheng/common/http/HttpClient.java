/************************************************************************
 *
 *
 ************************************************************************/
package com.chuansheng.common.http;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.net.BindException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

/**
 *      <h3>模拟发送Http请求</h3>
 *
 * @author: zhuchuansheng
 * @date: 2020/6/26
 * @time: 下午4:48
 * @version: 1.0
 */
public class HttpClient {

    /**
     * http客户端
     */
    private static CloseableHttpClient httpClient = httpClient = HttpClientBuilder.create().build();
    /**
     * git请求
     */
    private static HttpGet httpGet;
    /**
     * post请求
     */
    private static HttpPost httpPost;

    private static CloseableHttpResponse response;

    private static HttpEntity httpEntity;


//    public static String post(String uri, Map<String, String> param,
//                                           Map<String, String> Header) throws IOException {
//
//        httpPost = new HttpPost(uri);
//        RequestConfig config = RequestConfig.custom().setConnectTimeout(30000)
//                .setConnectionRequestTimeout(30000).setSocketTimeout(30000).build();
//        httpPost.setConfig(config);
//
//        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(HttpClient.getParam(param));
//        httpPost.setEntity(entity);
//        if(!Header.isEmpty()){
//            for (Map.Entry<String, String> entry : Header.entrySet()) {
//                httpPost.setHeader(entry.getKey(), entry.getValue());
//            }
//        }
//        response = httpClient.execute(httpPost);
//        httpEntity = response.getEntity();
//        if(httpEntity != null){
//
//            return  EntityUtils.toString(httpEntity, "UTF-8");
//        }
//
//        return null;
//    }
//
//    private static List<NameValuePair> getParam(Map<String, String> param) {
//
//        List<NameValuePair> list = new ArrayList<>();
//        for (Map.Entry<String, String> entry : param.entrySet()) {
//            list.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
//        }
//        return list;
//    }


    public static String post(String uri, Map<String, String> param, Map<String, String> header) {

        try {

            URL url = new URL(uri);
            HttpURLConnection content = (HttpURLConnection) url.openConnection();
            content.setDoInput(true);
            content.setDoOutput(true);
            content.setRequestMethod("POST");
            for (Map.Entry<String, String> entry : header.entrySet()) {
                content.setRequestProperty(entry.getKey(), entry.getValue());
            }
            OutputStream outputStream = content.getOutputStream();
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
            PrintWriter writer = new PrintWriter(bufferedOutputStream);
            writer.write(HttpClient.getParams(param));
            writer.flush();
            writer.close();

            InputStream inputStream = content.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            return bufferedReader.readLine();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


    private static String getParams(Map<String, String> param){

        StringBuffer params = new StringBuffer();
        if(Objects.isNull(param)){
            return "";
        }
        int index = 0;
        for (Map.Entry<String, String> entry : param.entrySet()) {
            if(index != 0){
                params.append("&");
            }
            params.append(entry.getKey() + "=" + entry.getValue());
            index++;
        }

        return params.toString();
    }

}