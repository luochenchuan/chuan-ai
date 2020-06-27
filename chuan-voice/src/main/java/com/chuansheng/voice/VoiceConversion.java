/************************************************************************
 *
 *
 ************************************************************************/
package com.chuansheng.voice;

import com.chuansheng.common.bean.param.VoiceParam;
import com.chuansheng.common.bean.result.VoiceResult;

/**
 *      <h3>语音转换</h3>
 *
 * @author: zhuchuansheng
 * @date: 2020/6/26
 * @time: 下午10:15
 * @version: 1.0
 */
public interface VoiceConversion {


    /**
     *      <h3>语音转换</h3>
     *
     * @param voiceParam  语音参数
     * @return
     */
    VoiceResult voiceConversion(VoiceParam voiceParam);
}
