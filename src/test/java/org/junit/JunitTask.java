package org.junit;

import java.util.Date;

import org.openqa.selenium.By;
import org.pom.LoginPojo;
import org.sample.BaseClass;

public class JunitTask extends BaseClass {

	@Test
	public void tc1() {

		driver.findElement(By.id("username")).sendKeys("thiyaguadmin");
		driver.findElement(By.id("password")).sendKeys("Admin@123");
		driver.findElement(By.xpath("//input[@value='Login']")).click();
	}

	@Before
	public void setup() {

		browserLaunch();
		browsermax();
		loadURL("https://adactinhotelapp.com/");
		System.out.println("Start Time: " +new Date());
	}

	@BeforeClass
	public static void preCondition() {
		System.out.println("Start");
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

	@After
	public void tearDown() {
		System.out.println("End Time: "+new Date());

	}

	@AfterClass
	public static void postcondition() {
		System.out.println("Close");

	}

}
