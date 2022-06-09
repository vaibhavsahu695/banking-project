package BaseClasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass1 {

	public static WebDriver getdriver(String browser)
	{
		
		WebDriver driver=null;
		
		if(browser.equals("chrome"))
		{
System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\Browser\\chromedriver.exe");
		
		 driver =new ChromeDriver();
		}
		
		
		else if(browser.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "src\\main\\resources\\Browser\\geckodriver.exe");
			
			 driver =new FirefoxDriver();
		}
		driver.navigate().to("https://www.flipkart.com/");
		driver.manage().window().maximize();
		return driver;
	}
}
