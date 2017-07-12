package com.test.gitapi.vo;

public class CommitVO {
	private String url;
	private PersonVO author;
	private PersonVO committer;
	private String message;
	private TreeVO tree;
	private int comment_count;
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public PersonVO getAuthor() {
		return author;
	}
	public void setAuthor(PersonVO author) {
		this.author = author;
	}
	public PersonVO getCommitter() {
		return committer;
	}
	public void setCommitter(PersonVO committer) {
		this.committer = committer;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public TreeVO getTree() {
		return tree;
	}
	public void setTree(TreeVO tree) {
		this.tree = tree;
	}
	public int getComment_count() {
		return comment_count;
	}
	public void setComment_count(int comment_count) {
		this.comment_count = comment_count;
	}
	@Override
	public String toString() {
		return "CommitVO [url=" + url + ", author=" + author + ", committer=" + committer + ", message=" + message
				+ ", tree=" + tree + ", comment_count=" + comment_count + "]";
	}
	
}
