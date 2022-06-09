package TestClasses;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import BaseClasses.BaseClass1;
import PomClasses.Cart_Page;
import PomClasses.Home_Page;
import PomClasses.Login_Page;
import PomClasses.ProductDetails_Page;

public class VerifyUserCanBuyProduct {

	ExtentHtmlReporter htmlReporter;
	ExtentReports report;
	ExtentTest test;
	
	WebDriver driver;
	Login_Page lp;
	Home_Page hp;
	Cart_Page cp;
	ProductDetails_Page pdp;
	
	
	@BeforeClass
	public void beforeclass()
	{
		htmlReporter = new ExtentHtmlReporter("ExtentReporter.html");
		report = new ExtentReports();
		report.attachReporter(htmlReporter);
		test = report.createTest("VerifyUserCanBuyProduct");

		
		driver=BaseClass1.getdriver("chrome");
	}
	
	@BeforeMethod
	public void beforemethode()
	{
		lp= new Login_Page(driver);
		hp= new Home_Page(driver);
		cp=new Cart_Page(driver);
		pdp= new ProductDetails_Page(driver);
		
		
	}
	
	@Test(priority=1)
	public void verifyusercanlogin()
	{
		lp.emailID();
		lp.Password();
		lp.logbutton();
		SoftAssert sa= new SoftAssert();
		sa.assertTrue(hp.namevisible());
		sa.assertAll();
	}
	
	@Test(priority=2)
	public void verifyusercansearch() throws EncryptedDocumentException, IOException
	{
		String data=hp.getDataFromExcelSheet("Sheet1", 0, 0);
		
		hp.searchfield(data);	
		hp.searchButton();
		Assert.assertTrue(hp.productisvisible());
				
				
	}
	
	@Test(priority=3)
	public void verifyusercanselectproduct() 
	{
		hp.clickonproduct();
		Assert.assertTrue(pdp.buynowbuttonisvisible());
		pdp.clickonaddtocart();
	
				
	}
	
	@Test(priority=4)
	public void verifyusercanplaceorder() throws InterruptedException 
	{
	Thread.sleep(2000);
		cp.placeorderbutton();
				
	}
	
	@Test(priority=5)
	public void verifyusercangotopaymentsc() throws InterruptedException 
	{
	Thread.sleep(2000);
		Assert.assertTrue(cp.summaryisvisible());
		Thread.sleep(2000);
		cp.clickoncontinuebutton();
		Thread.sleep(2000);
		cp.clickonacceptbutton();
	}
	
	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException
	{
		if(result.getStatus() == ITestResult.SUCCESS)
		{
			String path=hp.getss(driver, result.getName());
			test.log(Status.PASS, "Test is passed "+ result.getName(),MediaEntityBuilder.createScreenCaptureFromPath(path).build());
		}
		else
		{
			String path=hp.getss(driver, result.getName());
			test.log(Status.FAIL, "Test is failed " + result.getName(), MediaEntityBuilder.createScreenCaptureFromPath(path).build());
			
			
		}
	}
	
	@AfterClass
	public void afterclass()
	{
		report.flush();
		driver.close();
	}
	
	
	
	
	
}
