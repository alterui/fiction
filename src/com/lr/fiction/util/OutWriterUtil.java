package com.lr.fiction.util;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

/**
 * Created by ALTERUI on 2019/1/15 18:56
 */
public class OutWriterUtil {
    public static void getOutWriter(HttpServletRequest request, HttpServletResponse response, String output) {
        File f = new File(output);
        //获取文件名称
        String fileName = f.getName();
        //导出文件
        String agent = request.getHeader("User-Agent").toUpperCase();
        InputStream fis = null;
        OutputStream os = null;
        try {
            fis = new BufferedInputStream(new FileInputStream(f.getPath()));
            byte[] buffer;
            buffer = new byte[fis.available()];
            fis.read(buffer);
            response.reset();
            //由于火狐和其他浏览器显示名称的方式不相同，需要进行不同的编码处理
            if(agent.indexOf("FIREFOX") != -1){//火狐浏览器
                response.addHeader("Content-Disposition", "attachment;filename="+ new String(fileName.getBytes("GB2312"),"ISO-8859-1"));
            }else{//其他浏览器
                response.addHeader("Content-Disposition", "attachment;filename="+ URLEncoder.encode(fileName, "UTF-8"));
            }
            //设置response编码
            response.setCharacterEncoding("UTF-8");
            response.addHeader("Content-Length", "" + f.length());
            //设置输出文件类型
            response.setContentType("audio/mpeg");
            //获取response输出流
            os = response.getOutputStream();
            os.flush();
            // 输出文件
            os.write(buffer);
        }catch(Exception e){
            e.getMessage();
        } finally{
            //关闭流
            try {
                if(fis != null){
                    fis.close();
                }
            } catch (IOException e) {
                e.getMessage();
            } finally{
                try {
                    if(os != null){
                        os.flush();
                    }
                } catch (IOException e) {
                    e.getMessage();
                } finally{
                    try {
                        if(os != null){
                            os.close();
                        }
                    } catch (IOException e) {
                        e.getMessage();
                    }
                }
            }
        }
    }
}
