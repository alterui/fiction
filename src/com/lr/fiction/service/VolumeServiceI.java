package com.lr.fiction.service;

import com.lr.fiction.model.Volume;

import java.util.List;



public interface VolumeServiceI {
	List<Volume> selectAllVolume(String bno);
}
