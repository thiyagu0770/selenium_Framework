package org.sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.pom.LoginPojo;
import org.pom.SearchHotelPojo;

public class Sample extends BaseClass {

	public static void main(String[] args) throws Exception {

		browserLaunch();
		browsermax();
		loadURL("https://adactinhotelapp.com/");
		pageTitle();
		pageURL();
		/*closethebrowser();
		WebElement username = driver.findElement(By.id(""));
		passtxt(username, "");
		WebElement password = driver.findElement(By.id(""));
		passtxt(password, "");
		WebElement btn = driver.findElement(By.id(""));
		Btnclick(btn);
		screenshot("Facebook");
		
		WebElement loginbtn = driver.findElement(By.id(""));
		if (isDisplayed(loginbtn)) {
			loginbtn.click();
		}

		WebElement from = driver.findElement(By.id(""));
		WebElement to = driver.findElement(By.id(""));
		dragAndDrop(from, to);
		
		implicitWait(30);
		
		
		
		
		WebElement country = driver.findElement(By.id("country"));
		selectByValue(country, "India");
		selectByVisibleText(country, "IN");
		selectByIndex(country, 2);
		
		WebElement menu = driver.findElement(By.id("menu"));
		mouseHover(menu);
		
		WebElement doubleClickBtn = driver.findElement(By.id("dblClick"));
		doubleClick(doubleClickBtn);
		
		WebElement rightClickBtn = driver.findElement(By.id("rightClick"));
		rightClick(rightClickBtn);
		
		WebElement message = driver.findElement(By.id("message"));
		String text = BaseClass.getText(message);
		System.out.println(text);*/
		
		
		LoginPojo l = new LoginPojo();
		
		/*
		 * String t = excelRead(0, 0); String t1 = excelRead(0, 1);
		 * 
		 * passtxt(l.getUsername(), t); passtxt(l.getPassword(), t1);
		 * Btnclick(l.getLoginbtn());
		 */
		
		SearchHotelPojo s = new SearchHotelPojo();
		selectByVisibleText(s.getLocation(), "Sydney");
		selectByVisibleText(s.getHotel(), "Hotel Creek");
		selectByValue(s.getRoom(), "Standard");
		selectByIndex(s.getRoomnumber(), 2);
		selectByIndex(s.getAdult(), 1);
		selectByIndex(s.getChild(), 0);
		
		Btnclick(s.getClicksearch());
		
		if (isDisplayed(s.getSelectHotelpage())) {
			System.out.println("Successfully navigated to the selected hotel page");
		}
		
		Btnclick(s.getRadiobutton());
		Btnclick(s.getContinuebutton());
		
	}

}
