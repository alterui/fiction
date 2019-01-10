package com.lr.fiction.service;

import com.lr.fiction.model.UserInfo;

import java.util.List;



public interface UserServiceI {
	List<UserInfo> selectByUser(UserInfo user);
	boolean insert(UserInfo user);
	
}
