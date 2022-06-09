package PomClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilityClasses.UtilityClass;

public class ProductDetails_Page extends UtilityClass{

	
	WebDriver driver;
	
	public  ProductDetails_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
				
	}
	
	
	@FindBy(xpath="//button[@class='_2KpZ6l _2U9uOA ihZ75k _3AWRsL']")
	private WebElement buynow;

	
	@FindBy(xpath="//button[@class='_2KpZ6l _2U9uOA _3v1-ww']")
	private WebElement addtocartbutton;
	
	public boolean buynowbuttonisvisible()
	{
		try {
			WebElement element =explicitwait(driver,buynow);
			
			return true;
			
		}catch(Exception e)
		{
			return false;
		}
		}
	
	public void clickonaddtocart()
	{
		addtocartbutton.click();
	}
	
	
}
