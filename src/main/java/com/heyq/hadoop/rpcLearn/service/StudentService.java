package com.heyq.hadoop.rpcLearn.service;

public interface StudentService {
	long versionID = 1L;
	String findName(String studentId);
}
