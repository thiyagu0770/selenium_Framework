package org.sample;

import java.awt.Desktop.Action;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BaseClass {

	public static WebDriver driver;
	public static Actions a;

	public static void browserLaunch() {

		driver = new ChromeDriver();

	}

	public static void browsermax() {
		driver.manage().window().maximize();

	}

	public static void loadURL(String url) {
		driver.get(url);

	}

	public static void pageTitle() {
		String title = driver.getTitle();
		System.out.println(title);

	}

	public static String pageURL() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}

	public static void closethebrowser() {

		driver.close();
	}

	public static void passtxt(WebElement element, String username) {

		element.sendKeys(username);
	}

	public static void clearText(WebElement element) {
		element.clear();

	}
	
	
	public static void Btnclick(WebElement element) {
		element.click();

	}

	public static void screenshot(String file) throws Exception {
		TakesScreenshot t = (TakesScreenshot) driver;
		File source = t.getScreenshotAs(OutputType.FILE);
		File des = new File("D:\\DOC\\Testing-Workspace\\Selenium-Framework\\Screenshots" + file + ".png");
		FileUtils.copyFile(source, des);

	}

	public static boolean isDisplayed(WebElement element) {

		return element.isDisplayed();

	}

	public static void dragAndDrop(WebElement from, WebElement to) {
		a = new Actions(driver);
		a.dragAndDrop(from, to);
	}
	
	public static void implicitWait(int seconds) {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(seconds));

	}
	
	public static void explicitWait(WebElement element, int seconds) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	public static void selectByValue(WebElement element, String value) {
		Select s = new Select(element);
		s.selectByValue(value);
	}
	
	public static void selectByVisibleText(WebElement element, String text) {
		Select s = new Select(element);
		s.selectByVisibleText(text);

	}
	
	public static void selectByIndex(WebElement element,int index) {
		Select s = new Select(element);
		s.selectByIndex(index);

	}
	
	public static void mouseHover(WebElement element) {
		a = new Actions(driver);
		a.moveToElement(element).perform();

	}
	
	public static void doubleClick(WebElement element) {
		a = new Actions(driver);
		a.doubleClick(element).perform();
	}
	
	public static void rightClick(WebElement element) {
		a = new Actions(driver);
		a.contextClick(element).perform();

	}
	
	public static String getText(WebElement element) {
		
		return element.getText();
		
		
	}
	
	public static String excelRead(int rowNo, int cellNo) throws Exception {
		
	File f = new File("D:\\DOC\\Testing-Workspace\\Selenium-Framework\\excel\\Data.xlsx");
		
		// To read a file
		FileInputStream fis = new FileInputStream(f);
		
		Workbook w  = new XSSFWorkbook(fis);
		
		//workbook -->sheet -->row-->cell-->data
		//to get sheet from workbook interface
		Sheet s = w.getSheet("Credential");
		
		/*// to get row from sheet interface
		Row r = s.getRow(1);
		System.out.println(r);
		
		// to get cell from row interface
		Cell c = r.getCell(0);
		System.out.println(c);*/
		
		
			Row r = s.getRow(rowNo);
			
			
				Cell c = r.getCell(cellNo);
				
				// to get the type
				int cellType = c.getCellType();
				
				String value = "";
				
				if (cellType==1) {
					
					value = c.getStringCellValue();
				
					
				}else if (DateUtil.isCellDateFormatted(c)) {
					
					Date dd = c.getDateCellValue();
					SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
					value = sdf.format(dd);
					
					
				}else {
					
					double d = c.getNumericCellValue();
					long l = (long) d;
					value = String.valueOf(l);
					
					
				}
				
				return value;
				
			}
		

	
	
	
}
