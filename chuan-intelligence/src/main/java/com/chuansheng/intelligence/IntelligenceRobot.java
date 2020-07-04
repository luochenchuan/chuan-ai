/******************************************************************************** DESCRIPTION
 *<p>
 *    MODIFIED (YY/MM/DD)
 *      智能机器人
 *
 *    朱川生 2020/7/4 -  智能机器人
 *
 * <p>
 ******************************************************************************/
package com.chuansheng.intelligence;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.chuansheng.common.http.HttpClient;
import com.chuansheng.intelligence.bean.param.DialogueParam;
import com.chuansheng.intelligence.bean.param.Perception;
import com.chuansheng.intelligence.bean.param.Perception.Text;
import com.chuansheng.intelligence.bean.param.UserInfo;
import com.chuansheng.intelligence.bean.result.DialogueResult;
import com.chuansheng.intelligence.bean.result.Result;
import com.chuansheng.voice.play.PlayVoice;
import java.util.Map;
import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *      <h3>智能机器人</h3>
 *
 * @author ：zhuchuansheng
 * @date: 2020/7/4
 * @time: 13:32
 * @veriosn: 1.0-1
 */
@Component
public class IntelligenceRobot {


  private String uri = "http://openapi.tuling123.com/openapi/api/v2";


  @Autowired
  private PlayVoice playVoice;

  public void robot(String world) {

    DialogueParam param = new DialogueParam();

    Perception perception = new Perception();
    perception.setInputText(new Text(world));
    param.setPerception(perception);

    UserInfo userInfo = new UserInfo();
    userInfo.setApiKey("ad6fdce1a2e941678e16df06ec3a5b57");
    userInfo.setUserId("ffb59f15a6af2c1d");
    param.setUserInfo(userInfo);

    String result = HttpClient.post(uri, false, null, param);
    DialogueResult dialogueResult = JSON.parseObject(result, new TypeReference<DialogueResult>() {
    });

    Result[] results = dialogueResult.getResults();
    if(!Objects.isNull(result) && results.length > 0){

      Map<String, String> text = results[0].getValues();
      try {
        playVoice.play(text.get("text"));
      } catch (Exception e) {
        e.printStackTrace();
      }
    }

  }

}
