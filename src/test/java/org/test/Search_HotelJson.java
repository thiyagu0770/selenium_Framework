package org.test;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Iterator;

import org.json.JSONArray;
import org.json.JSONObject;
import org.pom.BookHotelPojo;
import org.pom.LoginPojo;
import org.pom.SearchHotelPojo;
import org.sample.BaseClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.utility.JsonUtility;

public class Search_HotelJson extends BaseClass {

	@BeforeClass
	private void preCondition() throws Exception {
		browserLaunch();
		browsermax();
		loadURL("https://adactinhotelapp.com/");
		
		JSONObject credentials = JsonUtility.getCredentials();
		
		LoginPojo l = new LoginPojo();
		
		passtxt(l.getUsername(), credentials.getString("username"));
		passtxt(l.getPassword(), credentials.getString("password"));
		l.getLoginbtn().click();
	
	}
	
	@DataProvider(name="searchData")
	public Object[][] getSearchData() throws Exception {
		
		JSONArray array = JsonUtility.getSearchHotelData();
		
		Object[][] data = new Object[array.length()][1];
		
		for (int i = 0; i < array.length(); i++) {
			data[i][0] = array.getJSONObject(i);
		}
		
		return data;

	}
	
	@DataProvider(name = "bookingData")
    public Object[][] getBookingData() throws Exception {

        JSONArray array = JsonUtility.getBookingData();

        Object[][] data = new Object[array.length()][1];

        for (int i = 0; i < array.length(); i++) {
            data[i][0] = array.getJSONObject(i);
        }

        return data;
    }
	
	  @Test(dataProvider = "searchData")
	  public void searchHotel(JSONObject searchData)  {
	  
	  SearchHotelPojo sh = new SearchHotelPojo();
	  
	  selectByVisibleText(sh.getLocation(), searchData.getString("location"));
	  selectByVisibleText(sh.getHotels(), searchData.getString("hotelName"));
      selectByVisibleText(sh.getRoomtype(), searchData.getString("roomType"));
      selectByVisibleText(sh.getRoomnumber(), searchData.getString("noOfRooms"));
      selectByVisibleText(sh.getChild(), searchData.getString("adults"));
	  
      sh.getClicksearch().click();
      sh.getContinuebutton().click();
      
      explicitWait(sh.getRadiobutton(), 5);
      sh.getRadiobutton().click();
	  sh.getContinuebutton().click();
	  }
	 
	
	  @Test(dataProvider = "bookingData", dependsOnMethods = "searchHotel")
	  public  void bookHotel(JSONObject bookingData) {
		
		  BookHotelPojo bh = new BookHotelPojo();
		  
		  explicitWait(bh.getFirstName(), 5);
		  
		  passtxt(bh.getFirstName(), bookingData.getString("firstName"));
		  passtxt(bh.getLastName(), bookingData.getString("lastName"));
		  passtxt(bh.getAddress(), bookingData.getString("billingAddress"));
		  passtxt(bh.getCreditCardNo(), bookingData.getString("creditCardNo"));
		  selectByVisibleText(bh.getCreditCardType(), bookingData.getString("creditCardType"));
		  selectByVisibleText(bh.getExpiryMonth(), bookingData.getString("expiryMonth"));
		  selectByVisibleText(bh.getExpiryYear(), bookingData.getString("expiryYear"));
		  passtxt(bh.getCVVNo(), bookingData.getString("cvvNumber"));
		  
		  bh.getBookNow().click();
		  
		  explicitWait(bh.getConfirmation(),15);
		  
		  String confirmationText = bh.getConfirmation().getText();
		  System.out.println("Confirmation Title: " + confirmationText);
		  
		  verifyText(bh.getConfirmation(), "Booking Confirmation");
		  
	}
	  
	
	@AfterClass
	private void postcondition() {
		
		//closethebrowser();

	}
	
}
