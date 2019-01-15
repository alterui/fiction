package com.lr.fiction.model;

import java.sql.Timestamp;
/**
 * 用户实体类
 * @author ALTERUI
 *
 */
public class Volume {
	private Integer vno;
	private String vname;
	private Integer bno;
	private Integer chapterCount;
	private Integer wordCount;
	private Timestamp createTime;
	private Integer state;
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Integer getVno() {
		return vno;
	}
	public void setVno(Integer vno) {
		this.vno = vno;
	}
	public String getVname() {
		return vname;
	}
	public void setVname(String vname) {
		this.vname = vname;
	}
	public Integer getBno() {
		return bno;
	}
	public void setBno(Integer bno) {
		this.bno = bno;
	}
	public Integer getChapterCount() {
		return chapterCount;
	}
	public void setChapterCount(Integer chapterCount) {
		this.chapterCount = chapterCount;
	}
	public Integer getWordCount() {
		return wordCount;
	}
	public void setWordCount(Integer wordCount) {
		this.wordCount = wordCount;
	}
	public Timestamp getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}
	
	
	
}
