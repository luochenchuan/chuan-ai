/************************************************************************
 *
 *
 ************************************************************************/
package com.chuansheng.voice.play;

import com.chuansheng.voice.GenerateFile;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 *      <h3>语音播放</h3>
 *
 * @author: zhuchuansheng
 * @date: 2020/6/27
 * @time: 上午9:55
 * @version: 1.0
 */
@Component
public class PlayVoice {

    @Autowired
    private GenerateFile generateFile;

    /**
     *  <h3>语音播放</h3>
     *
     * @param world
     */
    public void play(String world) {

        try {
            File mp3 = this.generateFile.generateFile(world);
            FileInputStream inputStream = new FileInputStream(mp3);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            Player player = new Player(bufferedInputStream);
            player.play();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (JavaLayerException e) {
            e.printStackTrace();
        }

    }


}
