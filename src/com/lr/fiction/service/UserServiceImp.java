package com.lr.fiction.service;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;



import com.lr.fiction.model.UserInfo;
import com.lr.fiction.util.JdbcUtil;

public class UserServiceImp implements UserServiceI {

	@Override
	public List<UserInfo> selectByUser(UserInfo user) {
		List<UserInfo> userList = new ArrayList<>();
		String sql = "select * from user_info where uaccout='" + user.getUaccount() + "' and upwd='" + user.getUpwd()+"'";
		ResultSet result = JdbcUtil.select(sql);

		try {
			while (result.next()) {
				UserInfo userInfo = new UserInfo();
				userInfo.setUno(result.getInt(1));
				userInfo.setUaccount(result.getString(2));
				userInfo.setUpwd(result.getString(3));
				userInfo.setCreatetime(result.getTimestamp(4));
				userInfo.setNickname(result.getString(5));
				userInfo.setLasttime(result.getTimestamp(6));
				userInfo.setMember(result.getInt(7));
				userList.add(userInfo);
			}
			return userList;
		} catch (Exception e) {
			return null;
		} finally {
			if (result != null)
				try {
					result.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}

	}

	@Override
	public boolean insert(UserInfo user) {
		StringBuffer sql = new StringBuffer("insert into user_info(uaccout,upwd,createtime,nickname,lasttime,member) values ( '");
		sql.append(user.getUaccount()+ "', '");
		sql.append(user.getUpwd() + "','");
		sql.append(user.getCreatetime() + "','");
		sql.append(user.getNickname() + "','"+user.getCreatetime()+"',");
		sql.append(0 + ")");
		boolean result = JdbcUtil.insert(sql.toString());

		return result;
	}

}
