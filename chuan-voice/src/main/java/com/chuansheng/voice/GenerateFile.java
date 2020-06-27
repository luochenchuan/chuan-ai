/************************************************************************
 *
 *
 ************************************************************************/
package com.chuansheng.voice;

import com.chuansheng.common.bean.param.VoiceParam;
import com.chuansheng.common.bean.result.VoiceResult;
import com.chuansheng.file.base64.Base64TOFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *      <h3>语音合成</h3>
 *
 * @author: zhuchuansheng
 * @date: 2020/6/27
 * @time: 下午3:18
 * @version: 1.0
 */
@Component
public class GenerateFile implements Serializable {

    @Autowired
    private VoiceConversion voiceConversion;

    @Autowired
    private Base64TOFile base64TOFile;

    /**
     *      <h3>语音合成</h3>
     *
     * @param world
     * @return
     */
    public File generateFile(String world){

        VoiceParam param = new VoiceParam();
        param.setTex(world);
        param.setType("tns");
        param.setPit(5);
        param.setAue(6);
        param.setPer(103);
        param.setSpd(5);
        param.setVol(5);
        Map<String, String> header = new HashMap<>();
        header.put("content-type", "application/x-www-form-urlencoded");
        header.put("cookie", "BIDUPSID=a355b1a21122d3fa98e5cf4c2b80b0ac; PSTM=1592041360; BAIDUID=a355b1a21122d3fa98e5cf4c2b80b0ac:FG=1; BDORZ=B490B5EBF6F3CD402E515D22BCDA1598; docVersion=0; CAMPAIGN_TRACK=cp%3Aainsem%7Cpf%3Apc%7Cpp%3Achanpin-yuyin%7Cpu%3Ayuyin-yuyinhecheng-1%7Cci%3A%7Ckw%3A10003523; BDSFRCVID=8-DOJeC62rwTnkjunS3quzVmh_4J7kvTH6aoa0kaVDBKoEdOrWbPEG0Pqf8g0Ku-h9_4ogKK0mOTHUkF_2uxOjjg8UtVJeC6EG0Ptf8g0M5; H_BDCLCKID_SF=tJuqoDPatC-3fP36q4rthbFXbf-X5-RLf2CO5l7F5l8-hCQe-U6-hRLH0pCq0xvJyCOM_Pn8BJ7xOKQphPnvyhLIhM58bq3A5PjjKfON3KJmVpC9bT3v5tDuMboy2-biWbRL2MbdJqv0sR6sDx6r-p8q5pOTaM7L3G7mWDJ25DnJhbLGe6Kbj6Q-DGDJqbjBHjbt0ROS543hJJ7Gq4bohjPDKtr9BtQmJJrz_JF-MRchDxOhQMo15hFebprX2fueQg-q3R7XflnShh3LXMoM5qKgKUcC0x-jLNOhVn0MW-5DepumWtnJyUnQhtnnBT5iMecL2IoFXbOmj43m0-RdhfL9LUIj-PKO5bRu_CFbtI_5MKKxD6RB5tLO5eTb5R3KHCrKBb5-HJOoDDk6yUOcy4LdjG5mKfru5TrtWfOlJp51fMTvbTOM3PDV3-Aq54R-2HnMbnbc0hLhbKoM5h3UQfbQ0bbhqP-jW5Ta5l66bJ7JOpkxhfnxy5KU24jLWTjZXK7TBt32LnvdDq5bLPI25-5bbN3ht6IDtb-DoKK-fbjEKRopMtOhq4tehH482fo9WDTm_DopypIMJKOGhl-53nLh3xc3KxPHLI7q-pPKKR7zfnORWfOx5U_wDHjEhpTR3mkjbpbyfn02OPKz0T5pKt4syP4j2xRnWNTWKfA-b4ncjRcTehoM3xI8LNj405OTbIFO0KJzJCFbMDIxj5Kben-W5gTOKJctato2WDkyHlbcOR5Jj65K5p0HMU6t2qte-6TE-J6SXKbkMnvC3MA--t4_DMRKLf3GWKO40p7-Qbomsq0x0bQte-bQyp_LaTcdJIOMahkMal7xOM5cQlPK5JkgMx6MqpQJQeQ-5KQN3KJmfbL9bT3YjjISKx-_J6_HJJnP; Hm_lvt_8b973192450250dd85b9011320b455ba=1593163647,1593163675,1593172482,1593174356; BDUSS=XhPLVhKS1NwZWxzaW53UEhacXVyZjlnQTAzekprUUEyV3NGQnZ6U0NVREhkaDFmRUFBQUFBJCQAAAAAAAAAAAEAAAB3F99-tLrO4GMAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAMfp9V7H6fVeU; H_PS_PSSID=31908_1422_31326_21100_32140_31660_32046_31848_26350; delPer=0; PSINO=2; Hm_lpvt_8b973192450250dd85b9011320b455ba=1593180236; __yjsv5_shitong=1.0_7_b4b54291f4c59571a91dab3fc611d958b2b8_700_1593180237137_222.130.221.106_150f228b");
        param.setHeaders(header);

        VoiceResult result = this.voiceConversion.voiceConversion(param);
        return this.base64TOFile.toFileMp3(result.getData().split(",")[1]);
    }

}
