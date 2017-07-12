package com.test.gitapi;

import java.io.IOException;
import java.text.ParseException;
import java.util.Date;
import javax.json.JsonObject;

import com.jcabi.github.Coordinates;
import com.jcabi.github.Github;
import com.jcabi.github.Repo;
import com.jcabi.github.RepoCommit;
import com.jcabi.github.RepoCommits;
import com.jcabi.github.RtGithub;
import com.test.gitapi.vo.CommitVO;
import com.test.gitapi.vo.CommitsVO;
import com.test.gitapi.vo.PersonVO;
import com.test.gitapi.vo.TreeVO;

public class TestJcabi implements Token{

	public static void main(String[] args) {
		// jcabi 라이브러리
		Github github = new RtGithub(token); // 토큰
	    Repo repo = github.repos().get(new Coordinates.Simple(user, repName)); // 유저아이디 / repo주소
	    
	    // 이슈 + 코멘트 
//		try {
//			Issue issue = repo.issues().create("How are you?", "Please tell me..."); // 이슈 만들기
//			issue.comments().post("My first comment!"); // 코멘트 남기기
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
	    
	    // 커밋 이록 관리
		try {
			RepoCommits commits = repo.commits(); // repo로 커밋기록 가져오기
//			RepoCommit commit = commits.get("d2b524d2c1e3a4d0a8734733e5debb1f07f47c21"); // sha로 커밋 객체 하나 가져오기
//			JsonObject jo = commit.json(); //커밋을 json으로 변환
//			System.out.println(jo);
			
			Iterable<RepoCommit> it = commits.iterate(filterData); //전체 커밋목록 가져오기
			for(RepoCommit i : it){
				JsonObject j = i.json();
				System.out.println(j.toString());
				
				CommitsVO vo = new TestJcabi().commits(j);
				
				System.out.println(vo.toString());
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 커밋목록을 담은 JsonObejct를 CommitsVO로 변환
	 * 
	 * @param JsonObject
	 * @return CommitsVO
	 * @throws ParseException
	 */
	private CommitsVO commits(JsonObject j) throws ParseException{
		//{"sha":"5d89a56d109188c22b0438889ea9737651907531","commit":{"author":{"name":"MAYEYE_JAR","email":"MAYEYE_JAR@DESKTOP-P5IN3M3","date":"2017-07-10T07:09:03Z"},"committer":{"name":"MAYEYE_JAR","email":"MAYEYE_JAR@DESKTOP-P5IN3M3","date":"2017-07-10T07:09:03Z"},"message":"commit by j :: 2017-07-10 16:06 create","tree":{"sha":"c664d80f5ef257905324b42448c195b58549cbfa","url":"https://api.github.com/repos/joaraaaaaaaaa/test/git/trees/c664d80f5ef257905324b42448c195b58549cbfa"},"url":"https://api.github.com/repos/joaraaaaaaaaa/test/git/commits/5d89a56d109188c22b0438889ea9737651907531","comment_count":0},"url":"https://api.github.com/repos/joaraaaaaaaaa/test/commits/5d89a56d109188c22b0438889ea9737651907531","html_url":"https://github.com/joaraaaaaaaaa/test/commit/5d89a56d109188c22b0438889ea9737651907531","comments_url":"https://api.github.com/repos/joaraaaaaaaaa/test/commits/5d89a56d109188c22b0438889ea9737651907531/comments","author":null,"committer":null,"parents":[],"stats":{"total":175,"additions":175,"deletions":0},"files":[{"sha":"35bca5eaed5fa628c9b2c8ab68004c11b7ae6b1b","filename":"gitapi/.classpath","status":"added","additions":26,"deletions":0,"changes":26,"blob_url":"https://github.com/joaraaaaaaaaa/test/blob/5d89a56d109188c22b0438889ea9737651907531/gitapi/.classpath","raw_url":"https://github.com/joaraaaaaaaaa/test/raw/5d89a56d109188c22b0438889ea9737651907531/gitapi/.classpath","contents_url":"https://api.github.com/repos/joaraaaaaaaaa/test/contents/gitapi/.classpath?ref=5d89a56d109188c22b0438889ea9737651907531","patch":"@@ -0,0 +1,26 @@\n+<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n+<classpath>\r\n+\t<classpathentry kind=\"src\" output=\"target/classes\" path=\"src/main/java\">\r\n+\t\t<attributes>\r\n+\t\t\t<attribute name=\"optional\" value=\"true\"/>\r\n+\t\t\t<attribute name=\"maven.pomderived\" value=\"true\"/>\r\n+\t\t</attributes>\r\n+\t</classpathentry>\r\n+\t<classpathentry kind=\"src\" output=\"target/test-classes\" path=\"src/test/java\">\r\n+\t\t<attributes>\r\n+\t\t\t<attribute name=\"optional\" value=\"true\"/>\r\n+\t\t\t<attribute name=\"maven.pomderived\" value=\"true\"/>\r\n+\t\t</attributes>\r\n+\t</classpathentry>\r\n+\t<classpathentry kind=\"con\" path=\"org.eclipse.jdt.launching.JRE_CONTAINER/org.eclipse.jdt.internal.debug.ui.launcher.StandardVMType/J2SE-1.5\">\r\n+\t\t<attributes>\r\n+\t\t\t<attribute name=\"maven.pomderived\" value=\"true\"/>\r\n+\t\t</attributes>\r\n+\t</classpathentry>\r\n+\t<classpathentry kind=\"con\" path=\"org.eclipse.m2e.MAVEN2_CLASSPATH_CONTAINER\">\r\n+\t\t<attributes>\r\n+\t\t\t<attribute name=\"maven.pomderived\" value=\"true\"/>\r\n+\t\t</attributes>\r\n+\t</classpathentry>\r\n+\t<classpathentry kind=\"output\" path=\"target/classes\"/>\r\n+</classpath>\r"},{"sha":"93b0fcaca8b48ba5c9c18c770bdee225d612a536","filename":"gitapi/.project","status":"added","additions":23,"deletions":0,"changes":23,"blob_url":"https://github.com/joaraaaaaaaaa/test/blob/5d89a56d109188c22b0438889ea9737651907531/gitapi/.project","raw_url":"https://github.com/joaraaaaaaaaa/test/raw/5d89a56d109188c22b0438889ea9737651907531/gitapi/.project","contents_url":"https://api.github.com/repos/joaraaaaaaaaa/test/contents/gitapi/.project?ref=5d89a56d109188c22b0438889ea9737651907531","patch":"@@ -0,0 +1,23 @@\n+<?xml version=\"1.0\" encoding=\"UTF-8\"?>\r\n+<projectDescription>\r\n+\t<name>gitapi</name>\r\n+\t<comment></comment>\r\n+\t<projects>\r\n+\t</projects>\r\n+\t<buildSpec>\r\n+\t\t<buildCommand>\r\n+\t\t\t<name>org.eclipse.jdt.core.javabuilder</name>\r\n+\t\t\t<arguments>\r\n+\t\t\t</arguments>\r\n+\t\t</buildCommand>\r\n+\t\t<buildCommand>\r\n+\t\t\t<name>org.eclipse.m2e.core.maven2Builder</name>\r\n+\t\t\t<arguments>\r\n+\t\t\t</arguments>\r\n+\t\t</buildCommand>\r\n+\t</buildSpec>\r\n+\t<natures>\r\n+\t\t<nature>org.eclipse.jdt.core.javanature</nature>\r\n+\t\t<nature>org.eclipse.m2e.core.maven2Nature</nature>\r\n+\t</natures>\r\n+</projectDescription>\r"},{"sha":"4c28b1a898a0f0bc507b93f8f5393d172709fe73","filename":"gitapi/.settings/org.eclipse.core.resources.prefs","status":"added","additions":4,"deletions":0,"changes":4,"blob_url":"https://github.com/joaraaaaaaaaa/test/blob/5d89a56d109188c22b0438889ea9737651907531/gitapi/.settings/org.eclipse.core.resources.prefs","raw_url":"https://github.com/joaraaaaaaaaa/test/raw/5d89a56d109188c22b0438889ea9737651907531/gitapi/.settings/org.eclipse.core.resources.prefs","contents_url":"https://api.github.com/repos/joaraaaaaaaaa/test/contents/gitapi/.settings/org.eclipse.core.resources.prefs?ref=5d89a56d109188c22b0438889ea9737651907531","patch":"@@ -0,0 +1,4 @@\n+eclipse.preferences.version=1\r\n+encoding//src/main/java=UTF-8\r\n+encoding//src/test/java=UTF-8\r\n+encoding/<project>=UTF-8\r"},{"sha":"8626026241ca3a932faeabe3cecd565331484e46","filename":"gitapi/.settings/org.eclipse.jdt.core.prefs","status":"added","additions":5,"deletions":0,"changes":5,"blob_url":"https://github.com/joaraaaaaaaaa/test/blob/5d89a56d109188c22b0438889ea9737651907531/gitapi/.settings/org.eclipse.jdt.core.prefs","raw_url":"https://github.com/joaraaaaaaaaa/test/raw/5d89a56d109188c22b0438889ea9737651907531/gitapi/.settings/org.eclipse.jdt.core.prefs","contents_url":"https://api.github.com/repos/joaraaaaaaaaa/test/contents/gitapi/.settings/org.eclipse.jdt.core.prefs?ref=5d89a56d109188c22b0438889ea9737651907531","patch":"@@ -0,0 +1,5 @@\n+eclipse.preferences.version=1\r\n+org.eclipse.jdt.core.compiler.codegen.targetPlatform=1.5\r\n+org.eclipse.jdt.core.compiler.compliance=1.5\r\n+org.eclipse.jdt.core.compiler.problem.forbiddenReference=warning\r\n+org.eclipse.jdt.core.compiler.source=1.5\r"},{"sha":"14b697b7bbb0d85e8d8ee19141a2a92d9ce211be","filename":"gitapi/.settings/org.eclipse.m2e.core.prefs","status":"added","additions":4,"deletions":0,"changes":4,"blob_url":"https://github.com/joaraaaaaaaaa/test/blob/5d89a56d109188c22b0438889ea9737651907531/gitapi/.settings/org.eclipse.m2e.core.prefs","raw_url":"https://github.com/joaraaaaaaaaa/test/raw/5d89a56d109188c22b0438889ea9737651907531/gitapi/.settings/org.eclipse.m2e.core.prefs","contents_url":"https://api.github.com/repos/joaraaaaaaaaa/test/contents/gitapi/.settings/org.eclipse.m2e.core.prefs?ref=5d89a56d109188c22b0438889ea9737651907531","patch":"@@ -0,0 +1,4 @@\n+activeProfiles=\r\n+eclipse.preferences.version=1\r\n+resolveWorkspaceProjects=true\r\n+version=1\r"},{"sha":"5894784a2ebd922a0fba41b182709cc36b04ddd8","filename":"gitapi/pom.xml","status":"added","additions":25,"deletions":0,"changes":25,"blob_url":"https://github.com/joaraaaaaaaaa/test/blob/5d89a56d109188c22b0438889ea9737651907531/gitapi/pom.xml","raw_url":"https://github.com/joaraaaaaaaaa/test/raw/5d89a56d109188c22b0438889ea9737651907531/gitapi/pom.xml","contents_url":"https://api.github.com/repos/joaraaaaaaaaa/test/contents/gitapi/pom.xml?ref=5d89a56d109188c22b0438889ea9737651907531","patch":"@@ -0,0 +1,25 @@\n+<project xmlns=\"http://maven.apache.org/POM/4.0.0\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\r\n+  xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd\">\r\n+  <modelVersion>4.0.0</modelVersion>\r\n+\r\n+  <groupId>com.test</groupId>\r\n+  <artifactId>gitapi</artifactId>\r\n+  <version>0.0.1-SNAPSHOT</version>\r\n+  <packaging>jar</packaging>\r\n+\r\n+  <name>gitapi</name>\r\n+  <url>http://maven.apache.org</url>\r\n+\r\n+  <properties>\r\n+    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>\r\n+  </properties>\r\n+\r\n+  <dependencies>\r\n+    <dependency>\r\n+      <groupId>junit</groupId>\r\n+      <artifactId>junit</artifactId>\r\n+      <version>3.8.1</version>\r\n+      <scope>test</scope>\r\n+    </dependency>\r\n+  </dependencies>\r\n+</project>\r"},{"sha":"a33ac63b97409e2d3ea09f49833a1b12f2eef7db","filename":"gitapi/src/main/java/com/test/gitapi/App.java","status":"added","additions":13,"deletions":0,"changes":13,"blob_url":"https://github.com/joaraaaaaaaaa/test/blob/5d89a56d109188c22b0438889ea9737651907531/gitapi/src/main/java/com/test/gitapi/App.java","raw_url":"https://github.com/joaraaaaaaaaa/test/raw/5d89a56d109188c22b0438889ea9737651907531/gitapi/src/main/java/com/test/gitapi/App.java","contents_url":"https://api.github.com/repos/joaraaaaaaaaa/test/contents/gitapi/src/main/java/com/test/gitapi/App.java?ref=5d89a56d109188c22b0438889ea9737651907531","patch":"@@ -0,0 +1,13 @@\n+package com.test.gitapi;\r\n+\r\n+/**\r\n+ * Hello world!\r\n+ *\r\n+ */\r\n+public class App \r\n+{\r\n+    public static void main( String[] args )\r\n+    {\r\n+        System.out.println( \"Hello World!\" );\r\n+    }\r\n+}\r"},{"sha":"e4be51bbf14d12b7962826362e151496f3a90040","filename":"gitapi/src/test/java/com/test/gitapi/AppTest.java","status":"added","additions":38,"deletions":0,"changes":38,"blob_url":"https://github.com/joaraaaaaaaaa/test/blob/5d89a56d109188c22b0438889ea9737651907531/gitapi/src/test/java/com/test/gitapi/AppTest.java","raw_url":"https://github.com/joaraaaaaaaaa/test/raw/5d89a56d109188c22b0438889ea9737651907531/gitapi/src/test/java/com/test/gitapi/AppTest.java","contents_url":"https://api.github.com/repos/joaraaaaaaaaa/test/contents/gitapi/src/test/java/com/test/gitapi/AppTest.java?ref=5d89a56d109188c22b0438889ea9737651907531","patch":"@@ -0,0 +1,38 @@\n+package com.test.gitapi;\r\n+\r\n+import junit.framework.Test;\r\n+import junit.framework.TestCase;\r\n+import junit.framework.TestSuite;\r\n+\r\n+/**\r\n+ * Unit test for simple App.\r\n+ */\r\n+public class AppTest \r\n+    extends TestCase\r\n+{\r\n+    /**\r\n+     * Create the test case\r\n+     *\r\n+     * @param testName name of the test case\r\n+     */\r\n+    public AppTest( String testName )\r\n+    {\r\n+        super( testName );\r\n+    }\r\n+\r\n+    /**\r\n+     * @return the suite of tests being tested\r\n+     */\r\n+    public static Test suite()\r\n+    {\r\n+        return new TestSuite( AppTest.class );\r\n+    }\r\n+\r\n+    /**\r\n+     * Rigourous Test :-)\r\n+     */\r\n+    public void testApp()\r\n+    {\r\n+        assertTrue( true );\r\n+    }\r\n+}\r"},{"sha":"90d75c66d1c8d74c04e85b0c4526f608fdec10f2","filename":"gitapi/target/classes/META-INF/MANIFEST.MF","status":"added","additions":5,"deletions":0,"changes":5,"blob_url":"https://github.com/joaraaaaaaaaa/test/blob/5d89a56d109188c22b0438889ea9737651907531/gitapi/target/classes/META-INF/MANIFEST.MF","raw_url":"https://github.com/joaraaaaaaaaa/test/raw/5d89a56d109188c22b0438889ea9737651907531/gitapi/target/classes/META-INF/MANIFEST.MF","contents_url":"https://api.github.com/repos/joaraaaaaaaaa/test/contents/gitapi/target/classes/META-INF/MANIFEST.MF?ref=5d89a56d109188c22b0438889ea9737651907531","patch":"@@ -0,0 +1,5 @@\n+Manifest-Version: 1.0\r\n+Built-By: MAYEYE_JAR\r\n+Build-Jdk: 1.8.0_131\r\n+Created-By: Maven Integration for Eclipse\r\n+\r"},{"sha":"3996adc0937014368c02c15a170c15550da57e96","filename":"gitapi/target/classes/META-INF/maven/com.test/gitapi/pom.properties","status":"added","additions":7,"deletions":0,"changes":7,"blob_url":"https://github.com/joaraaaaaaaaa/test/blob/5d89a56d109188c22b0438889ea9737651907531/gitapi/target/classes/META-INF/maven/com.test/gitapi/pom.properties","raw_url":"https://github.com/joaraaaaaaaaa/test/raw/5d89a56d109188c22b0438889ea9737651907531/gitapi/target/classes/META-INF/maven/com.test/gitapi/pom.properties","contents_url":"https://api.github.com/repos/joaraaaaaaaaa/test/contents/gitapi/target/classes/META-INF/maven/com.test/gitapi/pom.properties?ref=5d89a56d109188c22b0438889ea9737651907531","patch":"@@ -0,0 +1,7 @@\n+#Generated by Maven Integration for Eclipse\r\n+#Mon Jul 10 16:05:44 KST 2017\r\n+version=0.0.1-SNAPSHOT\r\n+groupId=com.test\r\n+m2e.projectName=gitapi\r\n+m2e.projectLocation=D\\:\\\\workspace_spring\\\\gitapi\r\n+artifactId=gitapi\r"},{"sha":"5894784a2ebd922a0fba41b182709cc36b04ddd8","filename":"gitapi/target/classes/META-INF/maven/com.test/gitapi/pom.xml","status":"added","additions":25,"deletions":0,"changes":25,"blob_url":"https://github.com/joaraaaaaaaaa/test/blob/5d89a56d109188c22b0438889ea9737651907531/gitapi/target/classes/META-INF/maven/com.test/gitapi/pom.xml","raw_url":"https://github.com/joaraaaaaaaaa/test/raw/5d89a56d109188c22b0438889ea9737651907531/gitapi/target/classes/META-INF/maven/com.test/gitapi/pom.xml","contents_url":"https://api.github.com/repos/joaraaaaaaaaa/test/contents/gitapi/target/classes/META-INF/maven/com.test/gitapi/pom.xml?ref=5d89a56d109188c22b0438889ea9737651907531","patch":"@@ -0,0 +1,25 @@\n+<project xmlns=\"http://maven.apache.org/POM/4.0.0\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\"\r\n+  xsi:schemaLocation=\"http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd\">\r\n+  <modelVersion>4.0.0</modelVersion>\r\n+\r\n+  <groupId>com.test</groupId>\r\n+  <artifactId>gitapi</artifactId>\r\n+  <version>0.0.1-SNAPSHOT</version>\r\n+  <packaging>jar</packaging>\r\n+\r\n+  <name>gitapi</name>\r\n+  <url>http://maven.apache.org</url>\r\n+\r\n+  <properties>\r\n+    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>\r\n+  </properties>\r\n+\r\n+  <dependencies>\r\n+    <dependency>\r\n+      <groupId>junit</groupId>\r\n+      <artifactId>junit</artifactId>\r\n+      <version>3.8.1</version>\r\n+      <scope>test</scope>\r\n+    </dependency>\r\n+  </dependencies>\r\n+</project>\r"},{"sha":"0a8b13c0bd67fd024f29d19df15fc3fb6e3b703e","filename":"gitapi/target/classes/com/test/gitapi/App.class","status":"added","additions":0,"deletions":0,"changes":0,"blob_url":"https://github.com/joaraaaaaaaaa/test/blob/5d89a56d109188c22b0438889ea9737651907531/gitapi/target/classes/com/test/gitapi/App.class","raw_url":"https://github.com/joaraaaaaaaaa/test/raw/5d89a56d109188c22b0438889ea9737651907531/gitapi/target/classes/com/test/gitapi/App.class","contents_url":"https://api.github.com/repos/joaraaaaaaaaa/test/contents/gitapi/target/classes/com/test/gitapi/App.class?ref=5d89a56d109188c22b0438889ea9737651907531"},{"sha":"15bce2ef29db05c2108da3304c68e488800400e4","filename":"gitapi/target/test-classes/com/test/gitapi/AppTest.class","status":"added","additions":0,"deletions":0,"changes":0,"blob_url":"https://github.com/joaraaaaaaaaa/test/blob/5d89a56d109188c22b0438889ea9737651907531/gitapi/target/test-classes/com/test/gitapi/AppTest.class","raw_url":"https://github.com/joaraaaaaaaaa/test/raw/5d89a56d109188c22b0438889ea9737651907531/gitapi/target/test-classes/com/test/gitapi/AppTest.class","contents_url":"https://api.github.com/repos/joaraaaaaaaaa/test/contents/gitapi/target/test-classes/com/test/gitapi/AppTest.class?ref=5d89a56d109188c22b0438889ea9737651907531"}]}
		CommitsVO vo = new CommitsVO();
		CommitVO commitVO = new CommitVO();
		PersonVO authorVO = new PersonVO();
		PersonVO committerVO = new PersonVO();
		TreeVO treeVO = new TreeVO();
		
		String sha = j.getString("sha");
		vo.setSha(sha);
		
		JsonObject commit = j.getJsonObject("commit");
		
		if(commit!=null){
			JsonObject author = commit.getJsonObject("author");
			if(author!=null){
				String date = author.getString("date");
				String temp = date.toString().replaceAll("T", " ").replaceAll("Z", "");
				Date dt = sdf.parse(temp);
				authorVO.setDate(dt);
				authorVO.setName(author.getString("name"));
				authorVO.setEmail(author.getString("email"));
				commitVO.setAuthor(authorVO);
			}
			
			JsonObject committer = commit.getJsonObject("author");
			if(committer!=null){
				String date2 = committer.getString("date");
				String temp2 = date2.toString().replaceAll("T", " ").replaceAll("Z", "");
				Date dt2 = sdf.parse(temp2);
				committerVO.setDate(dt2);
				committerVO.setName(committer.getString("name"));
				committerVO.setEmail(committer.getString("email"));
				commitVO.setCommitter(committerVO);
			}
			
			commitVO.setMessage(commit.getString("message"));
			
			JsonObject tree = commit.getJsonObject("tree");
			if(tree!=null){
				treeVO.setSha(tree.getString("sha"));
				treeVO.setUrl(tree.getString("url"));
				commitVO.setTree(treeVO);
			}
			
			commitVO.setUrl(commit.getString("url"));
			commitVO.setComment_count(commit.getInt("comment_count"));
			vo.setCommit(commitVO);
		}
		
		vo.setUrl(j.getString("url"));
		vo.setHtml_url(j.getString("html_url"));
		vo.setComments_url(j.getString("comments_url"));
		
		return vo;
	}

}
