package com.lr.fiction.service;

import com.lr.fiction.model.Writer;
import com.lr.fiction.util.JdbcUtil;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;



public class WriterServiceImp implements WriterServiceI{

	@Override
	public List<Writer> selectAllWriter() {
		List<Writer> writerList = new ArrayList<>();
		String sql = "select * from writer";
		ResultSet result = JdbcUtil.select(sql);
		
		try{
			
			while(result.next()){
				Writer writer = new Writer();
				writer.setWno(result.getInt(1));
				writer.setWname(result.getString(2));
				writer.setWaccout(result.getString(3));
				writer.setWpasswd(result.getString(4));
				writer.setCreatetime(result.getTimestamp(5));
				writer.setIssign(result.getInt(6));
				writerList.add(writer);
				
			}
			return writerList;
		}catch(Exception e){
			return null;
		}
	}

}
