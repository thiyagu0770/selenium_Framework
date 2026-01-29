package org.test;

import java.util.Date;

import org.openqa.selenium.By;
import org.pom.LoginPojo;
import org.sample.BaseClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
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

	@Test
	public void tc1() {

		driver.findElement(By.id("username")).sendKeys("thiyaguadmin");
		driver.findElement(By.id("password")).sendKeys("Admin@123");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	}

	@Test
	public void tc2() {

		LoginPojo l = new LoginPojo();
		l.getUsername().sendKeys("thiyaguadmin");
		l.getPassword().sendKeys("Admin@123");
		l.getLoginbtn().click();

	}

	@Test
	public void tc3() throws Exception {

		LoginPojo l = new LoginPojo();
		passtxt(l.getUsername(), excelRead(0, 0));
		passtxt(l.getPassword(), excelRead(0, 1));
		l.getLoginbtn().click();
	}

	@AfterMethod
	private void endTime() {
		System.out.println("End Time : " + new Date());

	}

	@AfterClass
	private void postcondition() {
		closethebrowser();

	}

}
