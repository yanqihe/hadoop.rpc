package com.heyq.hadoop.rpcLearn;

import java.io.IOException;

import org.apache.hadoop.HadoopIllegalArgumentException;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.ipc.RPC;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.heyq.hadoop.rpcLearn.service.StudentService;
import com.heyq.hadoop.rpcLearn.service.StudentServiceImpl;

public class Server {
	private static Logger logger = LoggerFactory.getLogger(Server.class);
	
	public static void main(String[] args) {
		RPC.Builder builder = new RPC.Builder(new Configuration());
		builder.setBindAddress("127.0.0.1");
		builder.setPort(12345);
		
		builder.setProtocol(StudentService.class);
		builder.setInstance(new StudentServiceImpl());
		
		try {
			RPC.Server server = builder.build();
			server.start();
		} catch (HadoopIllegalArgumentException e) {
			logger.error(e.getMessage(), e);
		} catch (IOException e) {
			logger.error(e.getMessage(), e);
		}
		
	}

}
