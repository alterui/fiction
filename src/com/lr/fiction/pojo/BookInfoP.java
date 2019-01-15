package com.lr.fiction.pojo;

import com.lr.fiction.model.BookInfo;
import com.lr.fiction.model.Category;
import com.lr.fiction.model.Writer;

import java.util.ArrayList;
import java.util.List;



public class BookInfoP extends BookInfo {
	private Writer writer;
	
	private Category category;
	
	private List<VolumeP> volumeList = new ArrayList<>();
	
	public List<VolumeP> getVolumeList() {
		return volumeList;
	}
	public void setVolumeList(List<VolumeP> volumeList) {
		this.volumeList = volumeList;
	}
	public Writer getWriter() {
		return writer;
	}
	public void setWriter(Writer writer) {
		this.writer = writer;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	
}
