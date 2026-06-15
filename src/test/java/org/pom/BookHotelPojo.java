package org.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sample.BaseClass;

public class BookHotelPojo extends BaseClass {
	
	public BookHotelPojo() {
		
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id = "first_name")
	private WebElement FirstName;
	
	@FindBy(id = "last_name")
	private WebElement LastName;
	
	
	@FindBy(xpath = "//textarea[@id='address']")
	private WebElement Address;
	
	
	@FindBy(xpath = "//input[@id='cc_num']")
	private WebElement CreditCardNo;
	
	
	@FindBy(xpath = "//select[@id='cc_type']")
	private WebElement CreditCardType;
	
	@FindBy(xpath = "//select[@id='cc_exp_month']")
	private WebElement ExpiryMonth;
	
	@FindBy(xpath = "//select[@id='cc_exp_year']")
	private WebElement ExpiryYear;
	
	
	@FindBy(xpath = "//input[@id='cc_cvv']")
	private WebElement CVVNo;
	
	
	@FindBy(id = "book_now")
	private WebElement BookNow;
	
	@FindBy(xpath = "//td[contains(text(),'Booking Confirmation')]")
	private WebElement Confirmation;


	public WebElement getConfirmation() {
		return Confirmation;
	}


	public WebElement getFirstName() {
		return FirstName;
	}


	public WebElement getLastName() {
		return LastName;
	}


	public WebElement getAddress() {
		return Address;
	}


	public WebElement getCreditCardNo() {
		return CreditCardNo;
	}


	public WebElement getCreditCardType() {
		return CreditCardType;
	}


	public WebElement getExpiryMonth() {
		return ExpiryMonth;
	}


	public WebElement getExpiryYear() {
		return ExpiryYear;
	}


	public WebElement getCVVNo() {
		return CVVNo;
	}


	public WebElement getBookNow() {
		return BookNow;
	}
	
	
}
