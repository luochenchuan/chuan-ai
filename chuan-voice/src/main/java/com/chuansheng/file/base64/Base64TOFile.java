/************************************************************************
 *
 *
 ************************************************************************/
package com.chuansheng.file.base64;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import sun.misc.BASE64Decoder;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *      <h3>文件转换</h3>
 *
 * @author: zhuchuansheng
 * @date: 2020/6/27
 * @time: 上午9:43
 * @version: 1.0
 */
@Component
public class Base64TOFile {


    /**
     *      <h3>将base64转换为音频文件</h3>
     *
     * @param base64
     * @return
     */
    public File toFileMp3(String base64){

        try {
            File map3 = new File(this.createTmpFile(),
                    System.currentTimeMillis() + ".mp3");
            BASE64Decoder decoder = new BASE64Decoder();
            byte[] bytes = decoder.decodeBuffer(base64);
            FileOutputStream outputStream = new FileOutputStream(map3);
            outputStream.write(bytes);
            outputStream.flush();
            outputStream.close();

            return map3;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }


    /**
     *  <h3>创建新文件</h3>
     *
     * @return
     */
    private File createTmpFile(){

        String absolutePath = null;
        try {
            ClassPathResource resource = new ClassPathResource("/");
            absolutePath = resource.getFile().getAbsolutePath();
            File file = new File(absolutePath + "/tmp");
            if(!file.exists()){
                file.mkdirs();
            }
            return file;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

}
