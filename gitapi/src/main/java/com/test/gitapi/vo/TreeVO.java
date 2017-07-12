package com.test.gitapi.vo;

public class TreeVO {
	private String url;
	private String sha;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getSha() {
		return sha;
	}
	public void setSha(String sha) {
		this.sha = sha;
	}
	@Override
	public String toString() {
		return "TreeVO [url=" + url + ", sha=" + sha + "]";
	}
	
}
