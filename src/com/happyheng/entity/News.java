package com.happyheng.entity;

public class News extends IdEntity {
	private String name;
	private String simplecontent;
	private String thumbnail;
	private String url;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSimplecontent() {
		return simplecontent;
	}
	public void setSimplecontent(String simplecontent) {
		this.simplecontent = simplecontent;
	}
	public String getThumbnail() {
		return thumbnail;
	}
	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	
}
