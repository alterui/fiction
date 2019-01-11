package com.lr.fiction.model;

import java.sql.Timestamp;

/**
 * 用户实体类
 * @author ALTERUI
 *
 */
public class UserInfo {
	private Integer uno;//编号
	private String uaccount;//账号
	private String upwd;//密码
	private Timestamp createtime;//创建时间
	private String nickname;//昵称
	private Timestamp lasttime;//最后登录时间
	private Integer member;//成员
	public Integer getUno() {
		return uno;
	}
	public void setUno(Integer uno) {
		this.uno = uno;
	}
	public String getUaccount() {
		return uaccount;
	}
	public void setUaccount(String uaccount) {
		this.uaccount = uaccount;
	}
	public String getUpwd() {
		return upwd;
	}
	public void setUpwd(String upwd) {
		this.upwd = upwd;
	}
	public Timestamp getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public Timestamp getLasttime() {
		return lasttime;
	}
	public void setLasttime(Timestamp lasttime) {
		this.lasttime = lasttime;
	}
	public Integer getMember() {
		return member;
	}
	public void setMember(Integer member) {
		this.member = member;
	}
	
}
