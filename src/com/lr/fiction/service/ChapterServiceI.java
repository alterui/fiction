package com.lr.fiction.service;

import com.lr.fiction.model.Chapter;

import java.util.List;


public interface ChapterServiceI {
	List<Chapter> selectAllChapterByNo(String bno);
}
