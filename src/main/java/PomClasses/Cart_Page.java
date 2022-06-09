package PomClasses;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UtilityClasses.UtilityClass;

public class Cart_Page extends UtilityClass{

	WebDriver driver;
	JavascriptExecutor executor;
	@FindBy(xpath="//div[text()='My Account']")
	private WebElement myaccount;
	
	@FindBy(xpath="//button[@class='_2KpZ6l _2ObVJD _3AWRsL']")
	private WebElement placeorderbutton;
	
	@FindBy(xpath="//span[text()='Order Summary']")
	private WebElement ordersummary;
	
	@FindBy(xpath="//button[@class='_2KpZ6l _1seccl _3AWRsL']")
	private WebElement continuebutton;
	
	@FindBy(xpath="//button[@class='_2KpZ6l _1uR9yB _3dESVI']")
	private WebElement acceptbutton;
	
	@FindBy(xpath="//div[@class='_3dsJAO']")
	private WebElement remove;
	
	@FindBy(xpath="//div[@class='_3dsJAO _24d-qY FhkMJZ']")
	private WebElement remove2;
	
	@FindBy(xpath="//button[@class='_2KpZ6l _1sbqEe _3dESVI']")
	private WebElement shopnow;
	
	public Cart_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
		this.driver=driver;
				
	}
	
	public boolean myaccountisvisible()
	{
		try {
			myaccount.isDisplayed();
			return true;
		}
		catch(Exception e)
		{
			return false;
			
		}
		
	}
	
	public void placeorderbutton()
	{
	JavascriptExecutor executor = (JavascriptExecutor)driver;
	executor.executeScript("arguments[0].click();", placeorderbutton);
		
		
	}
	
	public boolean summaryisvisible()
	{
		try {
			ordersummary.isDisplayed();
			return true;
			
		}catch(Exception e)
		{
			return false;
		}
		
	}
	
	public void clickoncontinuebutton()

	{
		continuebutton.click();
		
	}
	
	public void clickonacceptbutton()

	{
		acceptbutton.click();
		
	}
	public void clickonremove()
	{
		executor.executeScript("arguments[0].scrollIntoView(true)",driver.findElement(By.xpath("//div[@class='_3dsJAO']")));
		executor.executeScript("arguments[0].click();", remove);
		
	}
	
	public void clickonremove2()
	{
		Actions act= new Actions(driver);
		act.moveToElement(remove2).click().perform();
	}
	
	public boolean shopnowisvisible()
	{
		try {
			shopnow.isDisplayed();
			return true;
			
		}catch(Exception e)
		{
			return false;
		}
		
	}
}
