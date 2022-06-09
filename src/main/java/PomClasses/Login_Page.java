package PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilityClasses.UtilityClass;

public class Login_Page extends UtilityClass{
WebDriver driver;
	
	@FindBy(xpath="(//input[@type='text'])[2]")
	private WebElement email;
	
	@FindBy(xpath="//input[@type='password']")
	private WebElement password;
	
	@FindBy(xpath="//button[@class='_2KpZ6l _2HKlqd _3AWRsL']")
	private	WebElement loginbutton;
	
	public Login_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
	}
	public void emailID()
	{
		
		email.sendKeys("9511232485");
		
	}
	public void Password()
	{
		
		password.sendKeys("Flipkart@123");
		
	}
	public void logbutton()
	{
		loginbutton.click();
		
	}
	
}
