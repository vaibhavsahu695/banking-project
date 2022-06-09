package PomClasses;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilityClasses.UtilityClass;

public class Home_Page extends UtilityClass{

WebDriver driver;
	
	@FindBy(xpath="//input[@type='text']")
	private WebElement search;
	
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement searchbutton;
	
	@FindBy(xpath="//div[text()='My Account']")
	private WebElement myprofile;
	
	@FindBy(xpath="//div[@class='_4rR01T']")
	private WebElement product;
	
	
	    
	//public WebElement cartbutton;
	
	public Home_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	
	public void searchfield(String find)
	{
       search.sendKeys(find);
	
	}
	public void searchButton()
	{
	searchbutton.click();
	
	}
	
	public boolean namevisible()
	{
		try {
			WebElement element=explicitwait(driver, myprofile);
			return true;
		}catch(Exception e)
		{
			return false;
		}
		
		
	}
	public boolean productisvisible()
	{
		try {
			WebElement element1=explicitwait(driver, product);
			return true;
		}catch(Exception e)
		{
			return false;
		}
		
		
	}
	
	public void clearsearchfeild()
	{
		search.clear();
	}
	
	public void clickonproduct()
	{
		product.click();
		
		List<String> address= new ArrayList<String>(driver.getWindowHandles());
		
		driver.switchTo().window(address.get(1));
	}
	
	
	
}
