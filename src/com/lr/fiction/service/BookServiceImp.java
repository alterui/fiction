package com.lr.fiction.service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.lr.fiction.model.*;
import com.lr.fiction.pojo.BookInfoP;
import com.lr.fiction.pojo.VolumeP;
import com.lr.fiction.util.JdbcUtil;
import org.apache.commons.beanutils.BeanUtils;



public class BookServiceImp implements BookServiceI {

	WriterServiceI writerServiceI = new WriterServiceImp();
	CategoryServiceI cateServiceI = new CategoryServiceImp();
	VolumeServiceI volumeServiceI = new VolumeServiceImp();
	ChapterServiceI chapterServiceI = new ChapterServiceImp();

	// 拼装cateMap 以及writerMap
	public Map<Integer, Writer> getWriterMap() {
		List<Writer> writerList = writerServiceI.selectAllWriter();
		Map<Integer, Writer> writerMap = new HashMap<>();
		if (writerList != null) {
			for (Writer w : writerList) {
				writerMap.put(w.getWno(), w);
			}
		}
		return writerMap;
	}

	public Map<Integer, Category> getCateMap() {
		List<Category> cateList = cateServiceI.selectAllCategory();
		Map<Integer, Category> cateMap = new HashMap<>();
		if (cateList != null) {
			for (Category c : cateList) {
				cateMap.put(c.getCno(), c);
			}
		}
		return cateMap;
	}

	@Override
	public List<BookInfoP> selectAllBook(String sql) {
		ResultSet result = JdbcUtil.select(sql);
		List<BookInfo> bookList = new ArrayList<>();
		try {
			while (result.next()) {
				BookInfo book = new BookInfo();
				book.setBno(result.getInt(1));
				book.setBname(result.getString(2));
				book.setCno(result.getInt(3));
				book.setWno(result.getInt(4));
				book.setIntro(result.getString(5));
				book.setCreatetime(result.getTimestamp(6));
				book.setUpdatetime(result.getTimestamp(7));
				book.setIsupdate(result.getInt(8));
				book.setState(result.getInt(9));
				book.setImg(result.getString(10));
				bookList.add(book);
			}
			List<BookInfoP> newList = new ArrayList<>();
			Map<Integer, Writer> writerMap = getWriterMap();
			Map<Integer, Category> cateMap = getCateMap();

			for (BookInfo b : bookList) {
				BookInfoP newBook = new BookInfoP();
				BeanUtils.copyProperties(newBook, b);
				newBook.setCategory(cateMap.get(b.getCno()));
				newBook.setWriter(writerMap.get(b.getWno()));
				newList.add(newBook);
			}

			return newList;

		} catch (Exception e) {

			return null;
		} finally {

		}

	}

	@Override
	public List<BookInfo> selectByBname() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<BookInfo> selectByBid() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BookInfoP selectBookDetailByBno(String bno) {
		StringBuffer sql = new StringBuffer();
		sql.append("select * from book_info where bno =" + bno);
		List<BookInfoP> bookList = selectAllBook(sql.toString());
		//查询图书所有卷
		List<Volume> volumeList = volumeServiceI.selectAllVolume(bno);
		//查询图书所有章节
		List<Chapter> chapterList = chapterServiceI.selectAllChapterByNo(bno);
		//封装章节Map<Integer,List<Chapter>>  k--vno  value--list
		Map<Integer,List<Chapter>> chapterMap = new HashMap<>();
		for(Chapter c: chapterList){
			List<Chapter> list = chapterMap.get(c.getVno());
			if(list!=null){
				list.add(c);
				chapterMap.put(c.getVno(), list);
			}else{
				list = new ArrayList<>();
				list.add(c);
				chapterMap.put(c.getVno(), list);
			}
		}
//		ResultSet result = JdbcUtil.select(sql.toString());
		BookInfoP book = new BookInfoP();

		try {
//			while (result.next()) {
//				book.setBno(result.getInt(1));
//				book.setBname(result.getString(2));
//				book.setCno(result.getInt(3));
//				book.setWno(result.getInt(4));
//				book.setIntro(result.getString(5));
//				book.setCreatetime(result.getTimestamp(6));
//				book.setUpdatetime(result.getTimestamp(7));
//				book.setIsupdate(result.getInt(8));
//				book.setState(result.getInt(9));
//				book.setImg(result.getString(10));
//			}
			List<VolumeP> vList = new ArrayList<>();
			for(Volume v:volumeList){
					VolumeP volumeP = new VolumeP();
					BeanUtils.copyProperties(volumeP,v);
					volumeP.setChapterList(chapterMap.get(v.getVno()));
					vList.add(volumeP);
			}
			bookList.get(0).setVolumeList(vList);
			return bookList.get(0);
			
		} catch (Exception e) {
			return null;
		}

	}

	@Override
	public Chapter selectChapterByVnoChno(String bno, String chno) {
		// TODO Auto-generated method stub
		String sql = "select * from chapter where bno=" +bno+" and chno ="+chno;
		ResultSet result =JdbcUtil.select(sql);
		Chapter chapter = new Chapter();
		try{
			while(result.next()){
				chapter.setChno(result.getInt(1));
				chapter.setBno(result.getInt(2));
				chapter.setVno(result.getInt(3));
				chapter.setChname(result.getString(4));
				chapter.setChurl(result.getString(5));
				chapter.setCreatetime(result.getTimestamp(6));
				chapter.setPreid(result.getInt(7));
				chapter.setNextid(result.getInt(8));
				chapter.setWordcount(result.getInt(9));
			}
			return chapter;
		}catch(Exception e){
			return null;
		}
		
	}
}
