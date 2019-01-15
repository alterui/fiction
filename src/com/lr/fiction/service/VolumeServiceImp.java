package com.lr.fiction.service;

import com.lr.fiction.model.Volume;
import com.lr.fiction.util.JdbcUtil;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class VolumeServiceImp implements VolumeServiceI{

	@Override
	public List<Volume> selectAllVolume(String bno) {
		List<Volume> volumeList = new ArrayList<>();
		String sql = "select * from volume where bno=" + bno + "";
		ResultSet result = JdbcUtil.select(sql);
		try{
				while(result.next()){
					Volume volume = new Volume();
					volume.setVno(result.getInt(1));
					volume.setVname(result.getString(2));
					volume.setBno(result.getInt(3));
					volume.setChapterCount(result.getInt(4));
					volume.setWordCount(result.getInt(5));
					volume.setCreateTime(result.getTimestamp(6));
					//volume.setState(result.getInt(7));
					volumeList.add(volume);
				}
			return volumeList;
		}catch(Exception e){
			
			return null;
		}
		
		
	}

}
