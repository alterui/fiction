package fiction.util;
/**
 * JDBC连接池
 * @author ALTERUI
 *
 */


import fiction.model.UserInfo;

import java.sql.*;
import java.util.Date;


public class JDBCUtil {
	//数据库的连接对象
	private static Connection conn ;
	//执行语句
	private static Statement statement;
	//查询结果集
	private static ResultSet resultSet;
	
	public static void getConnection() {
		try {
			//通过反射加载mysql的驱动类
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/book?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull";
			String userName = "root";
			String pwd = "root";
			//获取数据库连接
			conn = DriverManager.getConnection(url, userName, pwd);
			//通过conn获取statement对象
			statement = conn.createStatement();

			//封装UserInfo对象
			UserInfo userInfo = new UserInfo();
			userInfo.setUaccount("liurui");
			userInfo.setUpwd("123456");
			Date date = new Date();
			Timestamp time = new Timestamp(date.getTime());

			userInfo.setCreatetime(time);
			userInfo.setNickname("瑞哥");
			userInfo.setLasttime(time);
			userInfo.setMember(1);

			//构建sql语句
			String sql = "INSERT INTO user_info(uaccout,upwd,createtime,nickname,lasttime,member) " +
					"VALUES('"+userInfo.getUaccount()+"','"+userInfo.getUpwd()+"'," +
					"'"+userInfo.getCreatetime()+"','"+userInfo.getNickname()+"'," +
					" '"+userInfo.getLasttime()+"','"+userInfo.getMember()+"')";
			//执行
			statement.execute(sql);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		getConnection();
	}
	
	
	
}
