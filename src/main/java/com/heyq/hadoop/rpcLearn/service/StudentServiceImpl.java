package com.heyq.hadoop.rpcLearn.service;

import java.io.IOException;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.ipc.ProtocolSignature;
import org.apache.hadoop.ipc.VersionedProtocol;

import com.heyq.hadoop.rpcLearn.cache.StudentInfoLocalCache;
import com.heyq.hadoop.rpcLearn.domain.StudentInfo;

public class StudentServiceImpl implements StudentService, VersionedProtocol{
	
	private StudentInfoLocalCache studentInfoCache = StudentInfoLocalCache.getInstance();

	public String findName(String studentId) {
		
		if (StringUtils.isEmpty(studentId)) {
			return null;
		}
		
		StudentInfo studentInfo = studentInfoCache.findName(studentId);
		if (studentInfo == null) {
			return null;
		}
		
		return studentInfo.getName();
	}

	public long getProtocolVersion(String protocol, long clientVersion) throws IOException {
		return StudentService.versionID;
	}

	public ProtocolSignature getProtocolSignature(String protocol, long clientVersion, int clientMethodsHash)
			throws IOException {
		return null;
	}

}
