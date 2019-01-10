package com.lr.fiction.util;

import java.io.PrintWriter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;

/**
 * json的工具类
 * @author jack
 *
 */
public class JSONUtils {


	public static String parseJSON(Object o) {
		String result = JSON.toJSONStringWithDateFormat(o, "yyyy-MM-dd", SerializerFeature.WriteDateUseDateFormat,
				SerializerFeature.DisableCircularReferenceDetect);
		
		return result;
	}
	
	
	
	public static void writeJSON(PrintWriter pw, String json) {

		pw.println(json);
		pw.flush();
		pw.close();

	}
	public static void writeJSON(PrintWriter pw, Object o) {

		pw.println(parseJSON(o));
		pw.flush();
		pw.close();

	}

}
