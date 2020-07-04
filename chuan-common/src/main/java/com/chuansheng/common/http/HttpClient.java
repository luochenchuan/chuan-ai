/******************************************************************************** DESCRIPTION
 *<p>
 *    MODIFIED (YY/MM/DD)
 *
 *
 *    朱川生 2020/7/4 -  
 *
 * <p>
 ******************************************************************************/
package com.chuansheng.common.http;

import com.alibaba.fastjson.JSON;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.Serializable;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.binary.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;
import org.springframework.boot.autoconfigure.web.servlet.MultipartProperties;

/**
 * <h3></h3>
 *
 * @author ：zhuchuansheng
 * @date: 2020/7/4
 * @time: 9:31
 * @veriosn: 1.0-1
 */
@Slf4j
public class HttpClient implements Serializable {

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
  /**
   * http响应
   */
  private static CloseableHttpResponse response;
  /**
   * 结果
   */
  private static HttpEntity httpEntity;


  public static String post(String url, boolean form,
      Map<String, String> headers, Object params) {

    try {

      httpPost = new HttpPost(url);
      if(form) {
        log.info("httpClient form 表单类型请求");
        httpPost.setEntity(HttpClient.selectParameters(params));
      } else {
        log.info("httpClient 普通 post 请求");
        httpPost.setEntity(new StringEntity(JSON.toJSONString(params), "UTF-8"));
      }
      if(!Objects.isNull(headers) && headers.size() > 0) {
        log.info("httpClient 设置 header, header的长度: " + headers.size());
        for (Entry<String, String> entry : headers.entrySet()) {
          log.debug("httpClient 设置 header, key: " + entry.getKey() + ", value: " + entry.getValue());
          httpPost.setHeader(entry.getKey(), entry.getValue());
        }
      }
      response = httpClient.execute(httpPost);
      if(!Objects.isNull(response)) {
        httpEntity = response.getEntity();
        return EntityUtils.toString(httpEntity, "UTF-8");
      }
    } catch (IOException e) {
      log.warn("httpClient 执行异常, 异常: ", e);
    }

    return null;
  }


  private static HttpEntity selectParameters(Object param) {

    MultipartEntityBuilder entityBuilder = MultipartEntityBuilder.create();
    Map<String, String> params = (Map<String, String>) param;
    for (Entry<String, String> entry : params.entrySet()) {

      log.debug("httpClient form 表单设置 参数, key: " + entry.getKey() + ", value: " + entry.getValue());
      entityBuilder.addTextBody(entry.getKey(), entry.getValue());
    }
    return entityBuilder.build();
  }


  public static String sendRequest(String method, String uri,
                          Map<String, String> header, Map<String, String> param) {

    try {

      URL url = new URL(uri);
      HttpURLConnection content = (HttpURLConnection) url.openConnection();
      content.setDoInput(true);
      content.setDoOutput(true);
      content.setRequestMethod(method);
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
