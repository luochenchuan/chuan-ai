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
    public File generateFile(String world) throws Exception {

        VoiceParam param = new VoiceParam();
        param.setTex(world);
        param.setType("tns");
        param.setPit(5);
        param.setAue(6);
        param.setPer(111);
        param.setSpd(5);
        param.setVol(5);
        Map<String, String> header = new HashMap<>();
        header.put("Content-Type", "application/x-www-form-urlencoded");
        header.put("Cookie", "BIDUPSID=2F0F48E20383D5726DA31E435CE62BC3; PSTM=1593327449; BAIDUID=2F0F48E20383D572E4E8051ECDC04C28:FG=1; BDORZ=B490B5EBF6F3CD402E515D22BCDA1598; BDRCVFR[feWj1Vr5u3D]=I67x6TjHwwYf0; delPer=0; PSINO=2; __yjsv5_shitong=1.0_7_5e4b3575ff7d61700ab419604a883180e758_300_1593826710674_222.130.56.8_c786f1cd; yjs_js_security_passport=118e146bf8b30fd0a1f1071c8b0621fc241c6fe3_1593826711_js; H_PS_PSSID=32099_1429_32124_32140_31253_32045_32231_31709_32108_31639; BCLID=4657906401958859165; BDSFRCVID=yqtOJexroG3_n4JupdFb-GtYomKKvV3TDYLEPqpX9IHBA0tVJeC6EG0Pts1-dEu-EHtdogKK0gOTH6KF_2uxOjjg8UtVJeC6EG0Ptf8g0M5; H_BDCLCKID_SF=tR32Wn7a5TrDHJTg5DTjhPrM2qQJWMT-MTryKKO7aDbkftJgQ4KVQn04hUciBb5ptanRhlRNLPj2oKTVyM5NDb0ZyxomtfQxtNRJQKDE5p5hKq5S5-OobUPUDMJ9LUkqW2cdot5yBbc8eIna5hjkbfJBQttjQn3hfIkj2CKLK-oj-DLljT-53e; CAMPAIGN_TRACK=cp%3Anpinzhuan%7Cpf%3Apc%7Cpp%3Anpinzhuan-biaoti%7Cpu%3Awenzineirong%7Cci%3A2020nzdc%7Ckw%3A2204396; CAMPAIGN_TRACK_TIME=2020-07-04+10%3A05%3A53; AGL_USER_ID=89356b03-d8b1-4c2c-9958-658263e65f88; Hm_lvt_28a17f66627d87f1d046eae152a1c93d=1593828355; _ga=GA1.2.127647227.1593828355; _gid=GA1.2.1675135222.1593828355; BDUSS=GFUSlVoZH5ZblhMZmdBc21LazZwT2xZU25EeklqUHBrUHNSV2hnRjFjNE5jU2RmRUFBQUFBJCQAAAAAAAAAAAEAAAB3F99-tLrO4GMAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA3k~14N5P9ed; bce-userbind-source=PASSPORT; bce-device-token=null; bce-ctl-client-cookies=\"BDUSS,bce-passport-stoken,bce-device-cuid,bce-device-token,BAIDUID\"; bce-auth-type=PASSPORT; bce-passport-stoken=f7c4247397ecf5734947c3b80845eb4ec835fb73ae24e3019d26aaf51d80f997; bce-sessionid=0015a5bfe5a0370431a90890f8ce1fd38b1; bce-user-info=2020-07-04T10:06:07Z|cc0ef0dabb0fbe061a2e21e092dadf76; bce-ctl-sessionmfa-cookie=bce-session; bce-session=06830266e7954b8c835b8deb7cdcd1728add32c1abf84f2fa4365f835e02678e|1bee4e293b34c64cd07fdfb07665dc90; bce-login-type=PASSPORT; bce-login-expire-time=\"2020-07-04T02:36:07Z|fe07402667d3f514e0b0e02195e28490\"; bce-login-display-name=%E6%98%A5%E6%A2%A7c; Hm_lpvt_28a17f66627d87f1d046eae152a1c93d=1593828418; BAIDU_CLOUD_TRACK_PATH=https%3A%2F%2Fcloud.baidu.com%2Fproduct%2Fspeech%2Ftts_online");
        param.setHeaders(header);

        VoiceResult result = this.voiceConversion.voiceConversion(param);
        if (result.getErrno() == 0) {
            return this.base64TOFile.toFileMp3(result.getData().split(",")[1]);
        } else {
            throw new Exception("语音合成错误");
        }
    }

}
