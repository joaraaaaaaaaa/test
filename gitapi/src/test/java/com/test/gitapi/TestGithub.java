package com.test.gitapi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.eclipse.egit.github.core.Blob;
import org.eclipse.egit.github.core.Comment;
import org.eclipse.egit.github.core.Commit;
import org.eclipse.egit.github.core.CommitUser;
import org.eclipse.egit.github.core.Download;
import org.eclipse.egit.github.core.Issue;
import org.eclipse.egit.github.core.Key;
import org.eclipse.egit.github.core.Reference;
import org.eclipse.egit.github.core.Repository;
import org.eclipse.egit.github.core.RepositoryCommit;
import org.eclipse.egit.github.core.RepositoryContents;
import org.eclipse.egit.github.core.RepositoryTag;
import org.eclipse.egit.github.core.Tag;
import org.eclipse.egit.github.core.Tree;
import org.eclipse.egit.github.core.TreeEntry;
import org.eclipse.egit.github.core.TypedResource;
import org.eclipse.egit.github.core.client.GitHubClient;
import org.eclipse.egit.github.core.client.IGitHubConstants;
import org.eclipse.egit.github.core.client.PageIterator;
import org.eclipse.egit.github.core.service.CommitService;
import org.eclipse.egit.github.core.service.ContentsService;
import org.eclipse.egit.github.core.service.DataService;
import org.eclipse.egit.github.core.service.DeployKeyService;
import org.eclipse.egit.github.core.service.DownloadService;
import org.eclipse.egit.github.core.service.IssueService;
import org.eclipse.egit.github.core.service.MarkdownService;
import org.eclipse.egit.github.core.service.RepositoryService;

public class TestGithub implements Token,IGitHubConstants {

	public static void main(String[] args) {
		// Basic authentication
		// GitHubClient client = new GitHubClient();
		// client.setCredentials("user", "passw0rd"); // 아이디-비밀번호 인증

		// OAuth2 token authentication
		GitHubClient client = new GitHubClient();
		client.setOAuth2Token(token); // 토큰 인증

		try {
			new TestGithub().test(client);
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	private void test(GitHubClient client) throws IOException {
		RepositoryService repositoryService = new RepositoryService();
		// try {
		// List<Repository> list = service.getRepositories("joaraaaaaaaaa"); //
		// 사용자
		// for (Repository repo : list) { // 각 저장소
		// String name = repo.getName(); // 저장소명
		// }
		// } catch (IOException e) {
		// e.printStackTrace();
		// }

		// 저장소 가져오기
		Repository repo = repositoryService.getRepository(user, repName); // 사용자명,
																			// 저장소명
		// System.out.println(sdf2.format(repo.getUpdatedAt())); //마지막 업데이트일
		// 사용자명, 저장소명 == 저장소
		// IRepositoryIdProvider repository = repo;
		
		// 커밋이나 태그 등을 업로드 할 때에는 reference를 이용한다.
		// refs/tags/[tagName]
		// refs/heads/[branchName]
		
		data(client, repo);
//		commit(client,repo);
//		issue(client,repo);
//		content(client,repo);
//		tag(repositoryService, client, repo);
//		deployKey(client, repo);
//		markDown(client, repo);
//		reference(client, repo);
	}
	@Deprecated
	private void serviceList() {
		// CollaboratorService
		// CommitService
		// ContentsService
		// DataService
		// DeployKeyService
		// DownloadService
		// EventService
		// GistService
		// GitHubService
		// IssueService
		// LabelService
		// MarkdownService
		// MilestoneService
		// OAuthService
		// OrganizationService
		// PullRequestService
		// RepositoryService
		// TeamService
		// UserService
		// WatcherService

		// READ_ME.md 파일 수정
	}

	private void commit(GitHubClient client, Repository repo) throws IOException {
		// 커밋 서비스 시작
		CommitService commitService = new CommitService(client); // 커밋서비스+인증
		// CommitService commitService = new CommitService(); //커밋서비스
		// commitService.getClient().setOAuth2Token(token); //커밋서비스인증

		// 커밋리스트 가져오기
		List<RepositoryCommit> commitList = commitService.getCommits(repo); // 커밋리스트
		for (RepositoryCommit r : commitList) {
			String sha = r.getSha(); // sha

			Commit c = r.getCommit(); // 커밋
			String message = c.getMessage(); // 커밋 코멘트

			CommitUser a = c.getAuthor(); // 커밋한 사람
			String name = a.getName(); // 커밋한 사람 이름
			Date date = a.getDate(); // 커밋한 날짜

			Tree t = c.getTree(); // 버젼
			String treeSha = t.getSha(); // 버젼sha
			String treeUrl = t.getUrl(); // 버젼url링크

			System.out.println(
					sha + ":" + message + ":" + name + ":" + sdf2.format(date) + ":" + treeSha + ":" + treeUrl);
		}
	}

	private void issue(GitHubClient client, Repository repo) throws IOException {

		// 이슈 서비스 시작
		IssueService issueService = new IssueService(client); // 이슈서비스+인증
		// IssueService issueService = new IssueService(); //이슈서비스
		// issueService.getClient().setOAuth2Token(token);

		// 이슈생성
		// Issue issue = new Issue();
		// issue.setBody("body");
		// issue.setTitle("title");
		// issueService.createIssue(user, repName, issue);

		// 이슈리스트 가져오기
		List<Issue> issueList = issueService.getIssues(user, repName, filterData);
		for (Issue i : issueList) {
			int number = i.getNumber();
			String title = i.getTitle();
			String body = i.getBody();
			System.out.println(number + ":" + title + ":" + body);

			// 코멘트 남기기
			// issueService.createComment(user, repName, number, "comment");

			// 코멘트리스트 가져오기
			List<Comment> commentList = issueService.getComments(repo, number);
			// List<Comment> commentList = issueService.getComments(user,
			// repName, number);
			for (Comment c : commentList) {
				String commentBody = c.getBody();
				System.out.println(commentBody);
			}
		}
	}

	@Deprecated
	private void download(GitHubClient client, Repository repo) throws IOException {
		DownloadService downloadService = new DownloadService(client);

		// 다운로드리스트
		List<Download> downloadList = downloadService.getDownloads(repo);
		if (downloadList.size() == 0)
			System.out.println("다운로드 없음");
		for (Download d : downloadList) {
			System.out.println(d.toString());
		}

		PageIterator<Download> pageIterator = downloadService.pageDownloads(repo);
		while (pageIterator.hasNext()) {
			Collection<Download> d = pageIterator.next();
			for (Download dd : d) {
				System.out.println(dd.getUrl());
			}
		}
	}

	private void content(GitHubClient client, Repository repo) throws IOException {
		ContentsService contentsService = new ContentsService(client);

		List<RepositoryContents> contentsList = contentsService.getContents(repo);
		for (RepositoryContents c : contentsList) {
			String sha = c.getSha();
			String name = c.getName();
			String content = c.getContent();
			String path = c.getPath();

			// System.out.println(sha+":"+name+":"+content+":"+path);
		}
		
		//readme 파일 읽기
		try {
			RepositoryContents c = contentsService.getReadme(repo);
			String sha = c.getSha();
			String name = c.getName();
			String content = c.getContent();
			String path = c.getPath();

			// base64 Encoding
			// byte[] encoded = Base64.encodeBase64(text.getBytes());
			// base64 Decoding
			byte[] decoded = Base64.decodeBase64(content);
			content = new String(decoded, "UTF-8");

			System.out.println(sha + ":" + name + ":" + content + ":" + path);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

	/**
	 * READ_ME.md 파일 수정
	 * @param client
	 * @param repo
	 * @throws IOException
	 */
	private void data(GitHubClient client, Repository repo) throws IOException {
		DataService dataService = new DataService(client);
		CommitService commitService = new CommitService(client);
		
		// 현재의 커밋 오브젝트를 취득 
		// get the current commit object
		List<RepositoryCommit> commitList = commitService.getCommits(repo); // 커밋리스트
		RepositoryCommit rCommit = commitList.get(0); //최신커밋
		Commit commit = rCommit.getCommit(); //커밋객체
		
		// 커밋으로부터 트리를 가져옴
		// retrieve the tree it points to
		Tree tree = commit.getTree(); //트리
		String treeSha = tree.getSha(); //트리샤
//		System.out.println(treeSha);
		
		// READ_ME.md 파일 수정--------------------------------------------------------
		String sha = "";
		ContentsService contentsService = new ContentsService(client);
		RepositoryContents c = null;
		// readme 파일 읽기 READ_ME.md sha 1d60b70ed8125fdfde9934ac0942548a25477971
		try {
			c = contentsService.getReadme(repo);
			sha = c.getSha();
//			System.out.println(sha);
		} catch (Exception e) {
			e.printStackTrace();
		}
		Blob blob = dataService.getBlob(repo, sha);
		// 안됨
		// blob.setEncoding(Blob.ENCODING_UTF8);
		// System.out.println(blob.getContent());
		String content = "<b>aaa</b>";
		byte[] encoded = Base64.encodeBase64(content.getBytes());
		blob.setContent(new String(encoded));
		
		// 수정된 blob 파일로 새로운 blob을 생성
		// change the content somehow and post a new blob object with that new content, getting a blob SHA back
		sha = dataService.createBlob(repo, blob);
//		System.out.println(sha+"수정된 sha");
		
		// 가리키는 트리를 가져옴
		tree = dataService.getTree(repo, tree.getSha());
		List<TreeEntry> treeList = tree.getTree();
		List<TreeEntry> ntList = new ArrayList<TreeEntry>();
		
		// 수정한 blob의 sha을 대체
		for(TreeEntry te : treeList){ 
			if(te.getSha().equals(c.getSha())){
				// 트리가 특정 파일 경로에 대해 가지고 있는 blob 객체의 내용을 검색한다.
				// retrieve the content of the blob object that tree has for that particular file path
				te.setSha(sha);
			}
			ntList.add(te);
		}
		
		// 새로운 트리를 만듦
		// post a new tree object with that file path pointer replaced with your new blob SHA getting a tree SHA back
		Tree ntree = dataService.createTree(repo, ntList);
		commit.setTree(ntree);
		commit.setMessage("new commit"); 
		
		// 새로운 커밋을 만듦
		// create a new commit object with the current commit SHA as the parent and the new tree SHA, getting a commit SHA back
		List<Commit> cList = new ArrayList<Commit>();
		Commit parent = new Commit();
		parent.setSha(rCommit.getSha());
		cList.add(parent);
		
		commit.setParents(cList);
		Commit ncommit = dataService.createCommit(repo, commit);
//		System.out.println(ncommit.getUrl());
		
		// branch의 reference를 업데이트
		// update the reference of your branch to point to the new commit SHA
		Reference reference = new Reference();
		reference.setRef("refs/heads/master"); //커밋할 branch
		TypedResource object = new TypedResource();
		object.setSha(ncommit.getSha());
		reference.setObject(object);
		dataService.editReference(repo, reference);
	}

	/**
	 * release 버젼관리
	 * 
	 * @param client
	 * @param repo
	 * @throws IOException
	 */
	private void tag(RepositoryService repositoryService, GitHubClient client, Repository repo) throws IOException {
		List<RepositoryTag> tagList = repositoryService.getTags(repo);
		// 태그 리스트
		for (RepositoryTag t : tagList) {
			TypedResource cm = t.getCommit();
			String name = t.getName(); // tag - 버젼
			String sha = cm.getSha();
			String url = cm.getUrl();
			
			String tagName = t.getName();
			String tarballUrl = t.getTarballUrl();
			String zipballUrl = t.getZipballUrl();
			
			System.out.println(sha + " : " + url + " : " + name);
			System.out.println(tagName + " - " + tarballUrl + " - " + zipballUrl);
		}
		
		// 태그 객체 생성
		// *** 태그 객체 생성과 태그 생성은 다름
		Tag tag = new Tag();
		tag.setTag("v0.0.4"); //태그
		tag.setMessage("initial version\n"); //메세지
		TypedResource obj = new TypedResource();
		obj.setType(TypedResource.TYPE_COMMIT); //tag타입
		obj.setSha("e2f5b0e25c535b8d8d94ed1297c976ae42754fb0"); //연결할 커밋 sha
		tag.setObject(obj);
		CommitUser tagger = new CommitUser();
		tagger.setName(user); //유저아이디
		tagger.setEmail("piyi@daum.net"); //이메일
		tagger.setDate(new Date());
		tag.setTagger(tagger);
		
		DataService dataService = new DataService(client);
		tag = dataService.createTag(repo, tag);
//		System.out.println(tag.getSha());
		
		// 태그 생성
		Reference reference = new Reference();
		// 1. 태그이름 / 커밋sha만으로 만들기
		reference.setRef("refs/tags/"+tag.getTag()); //refs/tags/[tagName]
		reference.setObject(tag.getObject()); //커밋 sha
		// 2. 태그 객체를 생성하여 받은 sha로 만들기
		TypedResource tagObj = new TypedResource();
		tagObj.setSha(tag.getSha());
		reference.setObject(tagObj); //생성한 태그 객체 sha
//		dataService.createReference(repo, reference);
		
		// 태그 객체 생성으로 만들어진 sha는 가져와짐
		Tag tagVersion = dataService.getTag(repo, "3c52332f8d8a6d333444b5a889560f5059065271");
//		System.out.println(tagVersion.getUrl());
		
	}

	private void deployKey(GitHubClient client, Repository repo) throws IOException {
		DeployKeyService deployKeyService = new DeployKeyService(client);
		// Key key = new Key();
		// key.setId(0);
		// key.setKey("key");
		// key.setTitle("title");
		// key.setUrl("url");
		// deployKeyService.createKey(repo, key);

		List<Key> keyList = deployKeyService.getKeys(repo);
		if (keyList.size() == 0)
			System.out.println("키 없음");
		for (Key k : keyList) {
			long id = k.getId();
			String title = k.getTitle();
			String key = k.getKey();

			System.out.println(id + ":" + title + ":" + key);
		}
	}
	private void markDown(GitHubClient client, Repository repo) throws IOException {
		MarkdownService markdownService = new MarkdownService(client);
	}
	private void reference(GitHubClient client, Repository repo) throws IOException {
		DataService dataService = new DataService(client);
		//레퍼런스 리스트
		List<Reference> referenceList = dataService.getReferences(repo);
		for(Reference r : referenceList){
			String ref = r.getRef();
			String url = r.getUrl();
			
			System.out.println(ref+" : "+url);
		}
	}
}
