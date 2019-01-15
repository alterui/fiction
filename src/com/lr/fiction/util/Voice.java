package com.lr.fiction.util;

import com.baidu.aip.speech.AipSpeech;
import com.baidu.aip.speech.TtsResponse;
import com.baidu.aip.util.Util;
import org.json.JSONObject;

import java.io.IOException;
import java.util.HashMap;

/**
 * Created by ALTERUI on 2019/1/15 14:49
 */
public class Voice {

    //设置APPID/AK/SK
    public static final String APP_ID = "15420875";
    public static final String API_KEY = "YRnnWojOKx691sglLcK4l1lf";
    public static final String SECRET_KEY = "GaWhNknwXVVeY1Rt4RDdtSBPg6MvZcaN";

    public static String getVoice(String word) {
        // 初始化一个AipSpeech
        AipSpeech client = new AipSpeech(APP_ID, API_KEY, SECRET_KEY);
        //输出目录
        String output = "D:/book/output.mp3";

        //发音人选择, 0为女声，1为男声，
        //3为情感合成-度逍遥，4为情感合成-度丫丫
        HashMap<String, Object> options = new HashMap<String, Object>();
        options.put("per", "4");

        TtsResponse res = client.synthesis(word, "zh", 1, options);
        byte[] data = res.getData();
        JSONObject res1 = res.getResult();
        if (data != null) {
            try {
                Util.writeBytesToFileSystem(data, output);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (res1 != null) {
            //System.out.println(res1.toString(2));
    }
        return output;
    }

}
