/************************************************************************
 *
 *
 ************************************************************************/
package com.chuansheng.voice.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.chuansheng.common.bean.param.VoiceParam;
import com.chuansheng.common.bean.result.VoiceResult;
import com.chuansheng.common.http.HttpClient;
import com.chuansheng.voice.VoiceConversion;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * @author: zhuchuansheng
 * @date: 2020/6/26
 * @time: 下午3:34
 * @version: 1.0
 */
@Component
public class BaiDuVoiceConversionImpl implements VoiceConversion {

    private String uri = "https://ai.baidu.com/aidemo";

    @Override
    public VoiceResult voiceConversion(VoiceParam voiceParam) {

        VoiceResult result = null;

        Map<String, String> param = new HashMap<>();
        param.put("aue", voiceParam.getAue().toString());
        param.put("tex", voiceParam.getTex());
        param.put("per", voiceParam.getPer().toString());
        param.put("vol", voiceParam.getVol().toString());
        param.put("pit", voiceParam.getPit().toString());
        param.put("type", voiceParam.getType());
        param.put("spd", voiceParam.getSpd().toString());

        String data = HttpClient.post(uri, param, voiceParam.getHeaders());
        result = JSON.parseObject(data, new TypeReference<VoiceResult>() {
        });

        return result;
    }

}
