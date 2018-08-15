package com.asher.test;

import org.apache.log4j.chainsaw.Main;

import com.asher.crm.utils.MyStringUtils;

public class TestMD5 {
    public static void main(String[] args) {
		System.out.println(MyStringUtils.getMD5Value("1234"));
	}
}
