package org.test;

import org.pom.LoginPojo;
import org.pom.SearchHotelPojo;
import org.sample.BaseClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Search_Hotel extends BaseClass {

	@BeforeClass
	private void preCondition() throws Exception {
		browserLaunch();
		browsermax();
		loadURL("https://adactinhotelapp.com/");
		
		LoginPojo l = new LoginPojo();
		String username = excelRead("Credential", 0, 0);
		String password = excelRead("Credential", 0, 1);
		
		passtxt(l.getUsername(), username);
		passtxt(l.getPassword(), password);
		l.getLoginbtn().click();

	}
	
	
	  @Test
	  public void searchHotel() throws Exception {
	  
	  SearchHotelPojo sh = new SearchHotelPojo();
	  
	  String location = excelRead("Hotel", 1, 0);
	  String hotel = excelRead("Hotel", 1, 1);
	  String roomType = excelRead("Hotel", 1, 2);
      String rooms = excelRead("Hotel", 1, 3);
      String adultperRoom = excelRead("Hotel", 1, 6);
      
      
      selectByVisibleText(sh.getLocation(), location);
      selectByVisibleText(sh.getHotel(), hotel);
      selectByVisibleText(sh.getRoom(), roomType);
      selectByValue(sh.getRoomnumber(), rooms);
      selectByVisibleText(sh.getAdult(), adultperRoom);
      
	  }
	 
	
	
	@AfterClass
	private void postcondition() {
		//closethebrowser();

	}
	
}
