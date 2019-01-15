package com.lr.fiction.service;

import com.lr.fiction.model.BookInfo;
import com.lr.fiction.model.Chapter;
import com.lr.fiction.pojo.BookInfoP;

import java.util.List;



public interface BookServiceI {
	List<BookInfoP> selectAllBook(String sql);
	List<BookInfo> selectByBname();
	List<BookInfo> selectByBid();
	BookInfoP selectBookDetailByBno(String bno);
	Chapter selectChapterByVnoChno(String bno, String chno);
}
