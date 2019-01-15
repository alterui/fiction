package com.lr.fiction.model;

import java.sql.Timestamp;
/**
 * 书实体类
 * @author ALTERUI
 *
 */
public class BookInfo {
	private Integer bno;
	private String bname;
	private Integer cno;
	private Integer wno;
	private String intro;
	private Timestamp createtime;
	private Timestamp updatetime;
	private Integer isupdate;
	private Integer state;
	private String img;
	public Integer getBno() {
		return bno;
	}
	public void setBno(Integer bno) {
		this.bno = bno;
	}
	public String getBname() {
		return bname;
	}
	public void setBname(String bname) {
		this.bname = bname;
	}
	public Integer getCno() {
		return cno;
	}
	public void setCno(Integer cno) {
		this.cno = cno;
	}
	public Integer getWno() {
		return wno;
	}
	public void setWno(Integer wno) {
		this.wno = wno;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public Timestamp getCreatetime() {
		return createtime;
	}
	public void setCreatetime(Timestamp createtime) {
		this.createtime = createtime;
	}
	public Timestamp getUpdatetime() {
		return updatetime;
	}
	public void setUpdatetime(Timestamp updatetime) {
		this.updatetime = updatetime;
	}
	public Integer getIsupdate() {
		return isupdate;
	}
	public void setIsupdate(Integer isupdate) {
		this.isupdate = isupdate;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
	
	
}
