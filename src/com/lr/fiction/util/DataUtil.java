package com.lr.fiction.util;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class DataUtil implements Serializable{

	private static final long serialVersionUID = 1L;
	private boolean result;//操作是否成功 成功 true  失败 false
	private Object ob;//结果
	private String msg;//提示信息
	private int total;//总的记录
	private List<?> data = new ArrayList<Object>();//查询出的对应结果
	
	public List<?> getData() {
		return data;
	}
	public void setData(List<?> data) {
		this.data = data;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public boolean isResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	public Object getOb() {
		return ob;
	}
	public void setOb(Object ob) {
		this.ob = ob;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
}
