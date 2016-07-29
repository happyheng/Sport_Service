package com.happyheng.entity.result;

import java.util.List;

import com.happyheng.entity.News;

public class NewsResult {
	private int code;
	private List<News> data;
	
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public List<News> getData() {
		return data;
	}
	
	public void setData(List<News> data) {
		this.data = data;
	}
	
	@Override
	public String toString() {
		return "NewsResult [code=" + code + ", data=" + data + "]";
	}
}
