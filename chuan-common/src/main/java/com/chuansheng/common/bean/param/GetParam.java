/************************************************************************
 *
 *
 ************************************************************************/
package com.chuansheng.common.bean.param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

/**
 *      <h3>get请求参数</h3>
 *
 * @author: zhuchuansheng
 * @date: 2020/6/26
 * @time: 下午5:00
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetParam implements Serializable {

    /**
     * 参数
     */
    private Map<String, Object> param;

    private String getParam() {

        StringBuffer params = new StringBuffer();
        int size = this.param.size();
        int index = 0;
        try {
            for (Map.Entry<String, Object> entry : param.entrySet()) {

                params.append(entry.getKey() + "=" + URLEncoder.encode(entry.getValue().toString(), "UTF-8"));
                index++;
                if (index != size) {
                    params.append("&");
                }
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return params.toString();
    }


    @Override
    public String toString(){

        return this.getParam();
    }
}
