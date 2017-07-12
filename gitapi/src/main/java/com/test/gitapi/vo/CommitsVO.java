package com.test.gitapi.vo;

import java.util.Arrays;

public class CommitsVO {
	private String url;
	private String sha;
	private String html_url;
	private String comments_url;
	private CommitVO commit;
	private AuthorVO author;
	private AuthorVO committer;
	private ParentsVO[] parents;
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
	public String getHtml_url() {
		return html_url;
	}
	public void setHtml_url(String html_url) {
		this.html_url = html_url;
	}
	public CommitVO getCommit() {
		return commit;
	}
	public void setCommit(CommitVO commit) {
		this.commit = commit;
	}
	public AuthorVO getAuthor() {
		return author;
	}
	public void setAuthor(AuthorVO author) {
		this.author = author;
	}
	public AuthorVO getCommitter() {
		return committer;
	}
	public void setCommitter(AuthorVO committer) {
		this.committer = committer;
	}
	public ParentsVO[] getParents() {
		return parents;
	}
	public void setParents(ParentsVO[] parents) {
		this.parents = parents;
	}
	
	public String getComments_url() {
		return comments_url;
	}
	public void setComments_url(String comments_url) {
		this.comments_url = comments_url;
	}
	@Override
	public String toString() {
		return "CommitsVO [url=" + url + ", sha=" + sha + ", html_url=" + html_url + ", comments_url=" + comments_url
				+ ", commit=" + commit + ", author=" + author + ", committer=" + committer + ", parents="
				+ Arrays.toString(parents) + "]";
	}
	
}
