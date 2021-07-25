package com.heyq.hadoop.rpcLearn.cache;

import java.util.HashMap;
import java.util.Map;

import com.heyq.hadoop.rpcLearn.domain.StudentInfo;

public class StudentInfoLocalCache {

	private static StudentInfoLocalCache instance = new StudentInfoLocalCache();

	private StudentInfoLocalCache() {
		super();
	}

	public static StudentInfoLocalCache getInstance() {
		return instance;
	}

	private static Map<String, StudentInfo> studentInfoMap = new HashMap<>();
	static {
		studentInfoMap.put("20210123456789",
				new StudentInfo.Builder().setStudentId("20210123456789").setName("心心").builder());
		studentInfoMap.put("G20210735010246",
				new StudentInfo.Builder().setStudentId("G20210735010246").setName("何衍其").builder());
	}

	public StudentInfo findName(String studentId) {
		return studentInfoMap.get(studentId);
	}

}
