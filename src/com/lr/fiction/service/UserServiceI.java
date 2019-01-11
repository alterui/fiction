package com.lr.fiction.service;

import com.lr.fiction.model.UserInfo;

import java.util.List;



public interface UserServiceI {
	/**
	 * 查询用户
	 * @param user
	 * @return
	 */
	List<UserInfo> selectByUser(UserInfo user);

	/**
	 * 插入用户
	 * @param user
	 * @return
	 */
	boolean insert(UserInfo user);
	
}
