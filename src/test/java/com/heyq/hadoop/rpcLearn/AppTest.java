package com.heyq.hadoop.rpcLearn;

import com.heyq.hadoop.rpcLearn.service.StudentService;
import com.heyq.hadoop.rpcLearn.service.StudentServiceImpl;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {

	private StudentService studentService;

	@Override
	public void setUp() throws Exception {
		studentService = new StudentServiceImpl();
	}

	/**
	 * Create the test case
	 *
	 * @param testName name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {
		assertTrue(true);
	}
	
	public void testFindMyName() {
		String myStudentId = "G20210735010246";
		assertTrue("自已的学号不正确", "何衍其".equals(studentService.findName(myStudentId)));
	}
	
	public void testFindClassTeacherName() {
		String myStudentId = "20210123456789";
		assertTrue("班班的学号不正确", "心心".equals(studentService.findName(myStudentId)));
	}
	
	public void testFindNotExistsStudentId() {
		String myStudentId = "20210000000000";
		assertTrue("学号不存在", studentService.findName(myStudentId) == null);
	}
	
}
