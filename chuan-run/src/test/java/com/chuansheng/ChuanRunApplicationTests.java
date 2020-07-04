package com.chuansheng;

import com.chuansheng.intelligence.IntelligenceRobot;
import com.chuansheng.voice.impl.BaiDuVoiceConversionImpl;
import com.chuansheng.voice.play.PlayVoice;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ChuanRunApplication.class)
public class ChuanRunApplicationTests {

	@Autowired
	private BaiDuVoiceConversionImpl baiDuVoiceConversion;

	@Test
	public void test() {

		System.out.println("test ... ");
	}

	@Autowired
	private PlayVoice playVoice;

	@Autowired
	private IntelligenceRobot intelligenceRobot;

	@Test
	public void testBaiDuVoiceConversion() throws Exception {

//		playVoice.play("你好呀, 川, 是否初始化");
		intelligenceRobot.robot("明天北京朝阳区有雨吗");
	}


}
