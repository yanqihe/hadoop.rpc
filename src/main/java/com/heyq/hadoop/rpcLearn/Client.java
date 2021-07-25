package com.heyq.hadoop.rpcLearn;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Arrays;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.heyq.hadoop.rpcLearn.service.StudentService;

public class Client {
	private static Logger logger = LoggerFactory.getLogger(Client.class);

	public static void main(String[] args) {
		try {
			StudentService proxy = RPC.getProxy(StudentService.class, 1L, new InetSocketAddress("127.0.0.1", 12345),
					new Configuration());

			List<String> studentIds = Arrays.asList("G20210735010246", "20210123456789", "20210000000000");
			for (String studentId : studentIds) {
				String studentName = proxy.findName(studentId);
				logger.info("学号：" + studentId + ", 姓名: " + studentName);
			}

		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
	}

}
