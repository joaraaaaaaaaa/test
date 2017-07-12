package com.test.gitapi;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.eclipse.egit.github.core.Comment;
import org.eclipse.egit.github.core.Commit;
import org.eclipse.egit.github.core.CommitUser;
import org.eclipse.egit.github.core.IRepositoryIdProvider;
import org.eclipse.egit.github.core.Issue;
import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.RepositoryCommit;
import org.eclipse.egit.github.core.client.GitHubClient;
import org.eclipse.egit.github.core.service.CommitService;
import org.eclipse.egit.github.core.service.IssueService;
import org.eclipse.egit.github.core.service.RepositoryService;

public class TestGithub implements Token{
 
	public static void main(String[] args) {
		// Basic authentication
		// GitHubClient client = new GitHubClient();
		// client.setCredentials("user", "passw0rd"); // 아이디-비밀번호 인증
		
		// OAuth2 token authentication
		GitHubClient client = new GitHubClient();
		client.setOAuth2Token(token); // 토큰 인증
		
		try {
			new TestGithub().test();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
	
	private void test() throws IOException{
		RepositoryService service = new RepositoryService();
//		try {
//			List<Repository> list = service.getRepositories("joaraaaaaaaaa"); // 사용자
//			for (Repository repo : list) { // 각 저장소
//				String name = repo.getName(); // 저장소명
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	
		// 저장소 가져오기
		Repository repo = service.getRepository(user, repName); //사용자명, 저장소명
		System.out.println(sdf2.format(repo.getUpdatedAt())); //마지막 업데이트일
		// 사용자명, 저장소명 == 저장소
		IRepositoryIdProvider repository = repo;
		
		// 커밋 서비스 시작
		CommitService commitService = new CommitService(); //커밋서비스
		commitService.getClient().setOAuth2Token(token); //커밋서비스인증
		
		// 커밋리스트 가져오기
		List<RepositoryCommit> commitList = commitService.getCommits(repo); //커밋리스트
		for(RepositoryCommit r:commitList){
			String sha = r.getSha(); //sha
			
			Commit c = r.getCommit(); //커밋
			String message = c.getMessage(); //커밋 코멘트
			
			CommitUser a = c.getAuthor(); //커밋한 사람
			String name = a.getName(); //커밋한 사람 이름
			Date date = a.getDate(); //커밋한 날짜
			
//			System.out.println(sha+":"+message+":"+name+":"+sdf2.format(date));
		}
		
		// 이슈 서비스 시작
		IssueService issueService = new IssueService(); //이슈서비스
		issueService.getClient().setOAuth2Token(token);
		
		// 이슈생성
//		Issue issue = new Issue();
//		issue.setBody("body");
//		issue.setTitle("title");
//		issueService.createIssue(user, repName, issue);
		
		// 이슈리스트 가져오기
		List<Issue> issueList = issueService.getIssues(user,repName,filterData);
		for(Issue i:issueList){
			int number = i.getNumber();
			String title = i.getTitle();
			String body = i.getBody();
			System.out.println(number+":"+title+":"+body);
			
			//코멘트 남기기
//			issueService.createComment(user, repName, number, "comment");
			
			//코멘트리스트 가져오기
			List<Comment> commentList = issueService.getComments(repository, number);
//			List<Comment> commentList = issueService.getComments(user, repName, number);
			for(Comment c:commentList){
				String commentBody = c.getBody();
				System.out.println(commentBody);
			}
		}
		
		
		
	}
}
