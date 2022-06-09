package UtilityClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class UtilityClass {
	
	
	
	
	
	public static String getss(WebDriver driver, String testname) throws IOException
	{
		Date date= new Date();
		SimpleDateFormat f= new SimpleDateFormat("YYYY-MM-dd-hh-mm-ss");
		String currentdate= f.format(date);
		System.out.println(currentdate);
		
		File source= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		String path= testname+".png";
		File dest= new File(path);
		FileHandler.copy(source, dest);
		
		return path;
	}
	public static WebElement explicitwait(WebDriver driver, WebElement element)
	{
		WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement element1= wait.until(ExpectedConditions.visibilityOf(element));
		
		return element1;
		
	}
	
	public static String getDataFromExcelSheet(String sheetName, int row, int cell) throws EncryptedDocumentException, IOException
	{
		
		FileInputStream file = new FileInputStream("src\\main\\resources\\TestData\\Products.xlsx");
		
		String data = WorkbookFactory.create(file).getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
		
		return data;
	}
	
	//Extentreporter
	
	public void reporter()
	{
		
		
		
	}
	
}
