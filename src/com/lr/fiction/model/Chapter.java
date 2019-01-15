package com.lr.fiction.model;

import java.sql.Timestamp;
/**
 * 用户实体类
 * @author ALTERUI
 *
 */
public class Chapter {
	private Integer chno;
	private Integer bno;
	private Integer vno;
	private String chname;
	private String churl;
	private Timestamp createtime;
	private Integer preid;
	private Integer nextid;
	private Integer wordcount;
	public Integer getChno() {
		return chno;
	}
	public void setChno(Integer chno) {
		this.chno = chno;
	}
	public Integer getBno() {
		return bno;
	}
	public void setBno(Integer bno) {
		this.bno = bno;
	}
	public Integer getVno() {
		return vno;
	}
	public void setVno(Integer vno) {
		this.vno = vno;
	}
	public String getChname() {
		return chname;
	}
	public void setChname(String chname) {
		this.chname = chname;
	}
	public String getChurl() {
		return churl;
	}
	public void setChurl(String churl) {
		this.churl = churl;
	}
	public Timestamp getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}
	public Integer getPreid() {
		return preid;
	}
	public void setPreid(Integer preid) {
		this.preid = preid;
	}
	public Integer getNextid() {
		return nextid;
	}
	public void setNextid(Integer nextid) {
		this.nextid = nextid;
	}
	public Integer getWordcount() {
		return wordcount;
	}
	public void setWordcount(Integer wordcount) {
		this.wordcount = wordcount;
	}
	
	
}
