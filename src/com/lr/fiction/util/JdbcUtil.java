package com.lr.fiction.util;
/**
 * JDBC连接池
 * @author ALTERUI
 *
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtil {

	public static Connection getConn() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/book?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull";
			String user = "root";
			String password = "root";
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		} finally {

		}

		return conn;
	}

	public static ResultSet select(String sql) {
		Connection conn = getConn();
		Statement statement = null;
		ResultSet result = null;
		try {
			statement = conn.createStatement();
			result = statement.executeQuery(sql);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public static boolean insert(String sql) {
		Connection conn = getConn();
		Statement statement = null;
		boolean flag=true ;
		try {
			statement = conn.createStatement();

			statement.execute(sql);
		} catch (SQLException e) {
			flag=false;
		}
		return flag;
	}
	public static void update(String sql) {
		Connection conn = getConn();
		Statement statement = null;
		try {
			statement = conn.createStatement();
			statement.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}


/*
import UserInfo;

import java.sql.*;
import java.util.Date;


public class JdbcUtil {
	//数据库的连接对象
	private static Connection conn ;
	//执行语句
	private static Statement statement;
	//查询结果集
	private static ResultSet resultSet;
	
	public static Statement getConnection() {
		try {
			//通过反射加载mysql的驱动类
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/book?useUnicode=true&characterEncoding=UTF-8&zeroDateTimeBehavior=convertToNull";
			String userName = "root";
			String pwd = "root";
			//获取数据库连接
			conn = DriverManager.getConnection(url, userName, pwd);
			//通过conn获取statement对象
			return conn.createStatement();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();

		}
		return null;
	}

	*/
/**
	 *
	 * @param sql
	 * @throws Exception
	 *//*

	public static void insert(String sql) throws Exception{
		getConnection().execute(sql);
	}


	
}
*/
