package TestClasses;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import BaseClasses.BaseClass1;
import PomClasses.Cart_Page;
import PomClasses.Home_Page;
import PomClasses.Login_Page;
import PomClasses.ProductDetails_Page;

public class VerifyUserCanRemoveProduct {

	WebDriver driver;
	Login_Page lp;
	Home_Page hp;
	Cart_Page cp;
	ProductDetails_Page pdp;
	
	
	@BeforeClass
	public void beforeclass()
	{
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
	
	@Test(priority=1)                         //git config --global user.email "you@example.com"
	                                          //git config --global user.name "Your Name
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
	public void verifyusercanselectproduct() throws InterruptedException 
	{
		hp.clickonproduct();
		Assert.assertTrue(pdp.buynowbuttonisvisible());
		pdp.clickonaddtocart();
		Thread.sleep(2000);
				
	}
	
	@Test(priority=4)
	public void verifyusercanremoveproduct() throws InterruptedException 
	{
		Thread.sleep(2000);

		cp.clickonremove();
		Thread.sleep(3000);
		cp.clickonremove2();
		
	
				
	}
	
	@AfterMethod
	public void aftermethod()
	{
		
		
		
	}
	
	@AfterClass
	public void afterclass()
	{
		
	}
	}