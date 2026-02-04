package org.test;

import java.util.Date;

import org.openqa.selenium.By;
import org.pom.LoginPojo;
import org.sample.BaseClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestNGTask extends BaseClass {

	@BeforeClass
	private void preCondition() {
		browserLaunch();
		browsermax();

	}

	@BeforeMethod
	private void startTime() {
		loadURL("https://adactinhotelapp.com/");
		System.out.println("Start Time : " + new Date());

	}

	/*
	 * @Parameters({ "email1", "Pass1" })
	 * 
	 * @Test public void tc1(String user, String pass) {
	 * 
	 * driver.findElement(By.id("username")).sendKeys(user);
	 * driver.findElement(By.id("password")).sendKeys(pass);
	 * driver.findElement(By.xpath("//input[@value='Login']")).click(); }
	 */

	@Test(dataProvider = "Data")
	public void tc2(String m, String n) {

		LoginPojo l = new LoginPojo();
		l.getUsername().sendKeys(m);
		l.getPassword().sendKeys(n);
		l.getLoginbtn().click();

	}

	@DataProvider(name = "Data")
	public Object[][] getData() {

		return new Object[][] { 
			{ "thiyaguadmin", "Admin@123" },
			{ "userthiyagu", "pass@123" },
			{ "admin", "Admin@1234" }, 
			{ "", "" },

		};
	}

	
	/*
	 * @Test public void tc3() throws Exception {
	 * 
	 * LoginPojo l = new LoginPojo(); passtxt(l.getUsername(), excelRead(0, 0));
	 * passtxt(l.getPassword(), excelRead(0, 1)); l.getLoginbtn().click(); }
	 */

	@AfterMethod
	private void endTime() {
		System.out.println("End Time : " + new Date());

	}

	@AfterClass
	private void postcondition() {
		closethebrowser();

	}

}
