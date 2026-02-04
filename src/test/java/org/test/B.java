package org.test;

import org.pom.LoginPojo;
import org.sample.BaseClass;
import org.testng.annotations.Test;

public class B extends BaseClass {

	@Test(dataProviderClass = TestNGTask.class, dataProvider = "Data")
	private void tc31(String v, String u) {
		browserLaunch();
		browsermax();
		loadURL("https://adactinhotelapp.com/");
		LoginPojo l = new LoginPojo();
		passtxt(l.getUsername(), v);
		passtxt(l.getPassword(), u);
		l.getLoginbtn().click();

	}
}
