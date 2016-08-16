package com.happyheng.entity.result;

import java.util.List;

import com.happyheng.entity.Location;

public class SportMessageResult {
	
	private int result;
	private List<Location> data;
	
	public int getResult() {
		return result;
	}
	public void setResult(int result) {
		this.result = result;
	}
	public List<Location> getData() {
		return data;
	}
	public void setData(List<Location> data) {
		this.data = data;
	}
	
	
}
