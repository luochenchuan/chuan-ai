/************************************************************************
 *
 *
 ************************************************************************/
package com.chuansheng.common.bean.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 *      <h3>语音转换结果集</h3>
 *
 * @author: zhuchuansheng
 * @date: 2020/6/26
 * @time: 下午9:35
 * @version: 1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VoiceResult implements Serializable {

    private String msg;

    private int errno;

    private String data;
}
