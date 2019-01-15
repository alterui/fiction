package com.lr.fiction.model;

import java.sql.Timestamp;
/**
 * 作者实体类
 * @author ALTERUI
 *
 */
public class Writer {
	private Integer wno;
	private String wname;
	private String waccout;
	private String wpasswd;
	private Timestamp createtime;
	private Integer issign;
	public Integer getWno() {
		return wno;
	}
	public void setWno(Integer wno) {
		this.wno = wno;
	}
	public String getWname() {
		return wname;
	}
	public void setWname(String wname) {
		this.wname = wname;
	}
	public String getWaccout() {
		return waccout;
	}
	public void setWaccout(String waccout) {
		this.waccout = waccout;
	}
	public String getWpasswd() {
		return wpasswd;
	}
	public void setWpasswd(String wpasswd) {
		this.wpasswd = wpasswd;
	}
	public Timestamp getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}
	public Integer getIssign() {
		return issign;
	}
	public void setIssign(Integer issign) {
		this.issign = issign;
	}
	
	
}
