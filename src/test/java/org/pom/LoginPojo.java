package org.pom;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sample.BaseClass;

public class LoginPojo extends BaseClass{
	

	public LoginPojo() {
		
		PageFactory.initElements(driver, this);
	}
	
			
	@FindBy(id="username")
	private WebElement username;
	
	@FindBy(name="password")
	private WebElement password;
	
	@FindBy(xpath="//input[@type='Submit']")
	private WebElement loginbtn;
	

	public WebElement getUsername() {
		return username;
	}

	public WebElement getPassword() {
		return password;
	}

	public WebElement getLoginbtn() {
		return loginbtn;
	}
	
	
	
}
