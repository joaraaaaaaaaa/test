package com.test.gitapi;

import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;

public interface Token {
	static String token = "59fa58a4931b26b389ae0d6f10b7f660a7e4928f";
	static String user = "joaraaaaaaaaa";
	static String repName = "test";
	static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
	static SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd a hh:mm:ss");
	static Map<String,String> filterData = new HashMap<String, String>(); //필터 //Url's parameters
}
