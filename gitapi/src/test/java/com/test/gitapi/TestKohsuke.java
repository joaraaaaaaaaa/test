package com.test.gitapi;

import java.io.IOException;

import org.kohsuke.github.GHRepository.Contributor;
import org.kohsuke.github.GitHub;

public class TestKohsuke implements Token{

	public static void main(String[] args) {
		try {
			new TestKohsuke().test();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void test() throws IOException{
		GitHub gh = GitHub.connect();
		for (Contributor c : gh.getRepository(user+"/"+repName).listContributors()) {
			System.out.println(c);
		}
	}
}
