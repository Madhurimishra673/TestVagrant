package Utilities;


import java.sql.Timestamp;

import org.testng.Reporter;

import com.aventstack.extentreports.Status;
import com.base.TestBase; 

public class Logger extends TestBase {
	
	public static void info(String msg) {
 
		System.out.println(msg);	
		test.log(Status.INFO, msg);
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String logs = timestamp + " [INFO] : " + msg;
		
		// TestNG Logs
		if(!msg.isEmpty()) { Reporter.log(logs); }
	}
	
	public static void info(Double msg) {
 
		System.out.println(msg);	
		test.log(Status.INFO,String.valueOf(msg));
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String logs = timestamp + " [INFO] : " + msg;
		
		// TestNG Logs
		if(msg != null) { Reporter.log(logs); }
	}
       
	public static void error(String msg) {
		
		System.err.println(msg);
		test.log(Status.ERROR, msg);
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String logs = timestamp + " [ERROR] : " + msg;
				
		// TestNG Logs
		if(!msg.isEmpty()) { Reporter.log(logs); }
	}

	public static void info(int msg)  {
 
		System.out.println(msg);	
		test.log(Status.INFO,String.valueOf(msg));
		
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String logs = timestamp + " [INFO] : " + msg;
	 
	}
	
	
	public static void warn(String msg) throws Exception {
		
		System.out.println(msg);
		test.log(Status.WARNING, msg);
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String logs = timestamp + " [WARN] : " + msg;
		
		// TestNG Logs
		if(!msg.isEmpty()) { Reporter.log(logs); }
	}
	
	public static void pass(String msg) throws Exception {
		
		System.out.println(msg);
		test.log(Status.PASS, msg);
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String logs = timestamp + " [PASS] : " + msg;
		
		// TestNG Logs
		if(!msg.isEmpty()) { Reporter.log(logs); }
	}
	
	public static void fail(String msg) throws Exception {
		
		System.err.println(msg);
		test.log(Status.FAIL, msg);
		Timestamp timestamp = new Timestamp(System.currentTimeMillis());
		String logs = timestamp + " [FAIL] : " + msg;
		
		// TestNG Logs
		if(!msg.isEmpty()) { Reporter.log(logs); }
	} 
}
