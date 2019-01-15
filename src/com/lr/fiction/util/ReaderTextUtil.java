package com.lr.fiction.util;

import java.io.*;
import java.util.List;

/**
 * Created by ALTERUI on 2019/1/15 18:57
 */
public class ReaderTextUtil {

    /**
     * 读取文本
     * @param churl
     * @param chapterList
     */
    public static void getReaderTxt(String churl, List<String> chapterList) {
        String lineTxt;
        try {
            File filename = new File(churl);
            InputStreamReader is = new InputStreamReader(new FileInputStream(filename));
            BufferedReader reader = new BufferedReader(is);
            while ((lineTxt = reader.readLine()) != null) {
                chapterList.add(lineTxt);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
