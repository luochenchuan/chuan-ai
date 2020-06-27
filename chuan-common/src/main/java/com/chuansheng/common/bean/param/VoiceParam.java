/************************************************************************
 *
 *
 ************************************************************************/
package com.chuansheng.common.bean.param;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.http.Header;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 *      <h3>语音转化参数</h3>
 *
 * @author: zhuchuansheng
 * @date: 2020/6/26
 * @time: 下午6:25
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VoiceParam implements Serializable {

    private String type;

    private Integer spd;

    private Integer pit;

    private Integer vol;

    private Integer per;

    private String tex;

    private Integer aue;

    private Map<String, String> headers;
}
