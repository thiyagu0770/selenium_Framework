package org.test;

import java.io.IOException;

import org.pom.BookHotelPojo;
import org.pom.LoginPojo;
import org.pom.SearchHotelPojo;
import org.sample.BaseClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.utility.ExcelUtility;

public class Search_HotelExcel extends BaseClass {

	@BeforeClass
	private void preCondition() throws Exception {
		browserLaunch();
		browsermax();
		loadURL("https://adactinhotelapp.com/");
		
		String path = System.getProperty("user.dir") + "\\excel\\Data.xlsx";
		ExcelUtility.loadExcel(path);
		
		LoginPojo l = new LoginPojo();
		
		String username  = ExcelUtility.getCellData("Credential", 0, 0);
		String password   = ExcelUtility.getCellData("Credential", 0, 1);
		
		passtxt(l.getUsername(), username);
	    passtxt(l.getPassword(), password);
	    l.getLoginbtn().click();
		
	}
	
	
	  @Test(priority = 0)
	  public void searchHotel() throws Exception {
	  
	  SearchHotelPojo sh = new SearchHotelPojo();
	  
	  explicitWait(sh.getLocation(), 10);
	  
	  String location = ExcelUtility.getCellData("Hotel", 1, 0);
	  String Hotel = ExcelUtility.getCellData("Hotel", 1, 1);
	  String roomtype = ExcelUtility.getCellData("Hotel", 1, 2);
	  String noofrooms = ExcelUtility.getCellData("Hotel", 1, 3);
	  String adultperRoom = ExcelUtility.getCellData("Hotel", 1, 6);

      
      selectByVisibleText(sh.getLocation(), location);
      selectByVisibleText(sh.getHotels(), Hotel);
      selectByVisibleText(sh.getRoomtype(), roomtype);
      selectByVisibleText(sh.getRoomnumber(), noofrooms);
      selectByVisibleText(sh.getAdult(), adultperRoom);
      sh.getClicksearch().click();
      sh.getContinuebutton().click();
      
      explicitWait(sh.getRadiobutton(), 5);
      sh.getRadiobutton().click();
      sh.getContinuebutton().click();
      
      
	  }
	 
	  @Test(priority = 1)
	  public void bookHotel() {
		
		  BookHotelPojo bh = new BookHotelPojo();
		  String Firstname = ExcelUtility.getCellData("BookHotel", 1, 0);
		  String lastname = ExcelUtility.getCellData("BookHotel", 1, 1);
		  String address = ExcelUtility.getCellData("BookHotel", 1, 2);
		  String CreditCardNo = ExcelUtility.getCellData("BookHotel", 1, 3);
		  String CreditCardType = ExcelUtility.getCellData("BookHotel", 1, 4);
		  String Expirymonth = ExcelUtility.getCellData("BookHotel", 1, 5);
		  String ExpiryYear = ExcelUtility.getCellData("BookHotel", 1, 6);
		  String CVV = ExcelUtility.getCellData("BookHotel", 1, 7);
		  
		  explicitWait(bh.getFirstName(), 10);
		  passtxt(bh.getFirstName(), Firstname);
		  passtxt(bh.getLastName(), lastname);
		  passtxt(bh.getAddress(), address);
		  passtxt(bh.getCreditCardNo(), CreditCardNo);
		  selectByVisibleText(bh.getCreditCardType(), CreditCardType);
		  selectByVisibleText(bh.getExpiryMonth(), Expirymonth);
		  selectByVisibleText(bh.getExpiryYear(), ExpiryYear);
		  passtxt(bh.getCVVNo(), CVV);
		  
		  bh.getBookNow().click();
		  
		  explicitWait(bh.getConfirmation(),15);
		  
		  String confirmationText = bh.getConfirmation().getText();
		  System.out.println("Confirmation Title: " + confirmationText);
		  
	}
	  
	
	@AfterClass
	private void postcondition() throws Exception {
		ExcelUtility.closeExcel();
		//closethebrowser();

	}
	
}
