package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.base.TestBase;



public class ExtentSetup extends TestBase{
	
	public static ExtentReports setUpExtentReport() {
		
		
		String reportpath=System.getProperty("user.dir")+"/target/Reports/index.html";
		ExtentSparkReporter sparkReport=new ExtentSparkReporter(reportpath);
		extent = new ExtentReports();
		extent.attachReporter(sparkReport);
		
		sparkReport.config().setDocumentTitle("Report");
		sparkReport.config().setTheme(Theme.DARK);
		sparkReport.config().setReportName("Ebay Automation Report");
		sparkReport.config().setAutoCreateRelativePathMedia(true);
	//	extent.setSystemInfo("Executed on Environment", Config.getProperty("testsiteurl"));
	//	extent.setSystemInfo("Executed by User", System.getProperty("user.name"));
		
		return extent;
	}
}
