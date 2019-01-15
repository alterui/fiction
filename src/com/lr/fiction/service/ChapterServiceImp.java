package com.lr.fiction.service;

import com.lr.fiction.model.Chapter;
import com.lr.fiction.util.JdbcUtil;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class ChapterServiceImp implements ChapterServiceI {

	@Override
	public List<Chapter> selectAllChapterByNo(String bno) {
		List<Chapter> chapterList = new ArrayList<>();
		String sql = "select * from chapter where  bno = " + bno + " order by chno";
		ResultSet result = JdbcUtil.select(sql);

		try {
			while(result.next()){
				Chapter chapter = new Chapter();
				chapter.setChno(result.getInt(1));
				chapter.setBno(result.getInt(2));
				chapter.setVno(result.getInt(3));
				chapter.setChname(result.getString(4));
				chapter.setChurl(result.getString(5));
				chapter.setCreatetime(result.getTimestamp(6));
				chapter.setPreid(result.getInt(7));
				chapter.setNextid(result.getInt(8));
				chapter.setWordcount(result.getInt(9));
				chapterList.add(chapter);
			}
			return chapterList;
		} catch (Exception e) {
			return null;
		}
	}

}
