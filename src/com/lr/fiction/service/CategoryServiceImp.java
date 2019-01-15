package com.lr.fiction.service;

import com.lr.fiction.model.Category;
import com.lr.fiction.util.JdbcUtil;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class CategoryServiceImp implements CategoryServiceI {

	@Override
	public List<Category> selectAllCategory() {
		String sql = "select * from category";
		List<Category> cateList = new ArrayList<>();
		ResultSet result = JdbcUtil.select(sql);
		try{
			while(result.next()){
				Category cate = new Category();
				cate.setCno(result.getInt(1));
				cate.setCname(result.getString(2));
				cateList.add(cate);
			}
			return cateList;
		}catch(Exception e){
			return null;
		}
	}

}
