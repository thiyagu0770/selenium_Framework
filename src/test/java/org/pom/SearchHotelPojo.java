package org.pom;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sample.BaseClass;

public class SearchHotelPojo extends BaseClass {
	
	public SearchHotelPojo() {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(id="location")
	private WebElement location;
	
	@FindBy(id="hotels")
	private WebElement hotel;
	
	@FindBy(id="room_type")
	private WebElement room;
	
	@FindBy(id="room_nos")
	private WebElement roomnumber;
	
	@FindBy(id="adult_room")
	private WebElement adult;
	
	@FindBy(id="child_room")
	private WebElement child;
	
	@FindBy(id="Submit")
	private WebElement clicksearch;
	
	@FindBy(xpath="//td[normalize-space()='Select Hotel']")
	private WebElement SelectHotelpage;
	
	@FindBy(id="radiobutton_0")
	private WebElement radiobutton;
	
	@FindBy(id="continue")
	private WebElement continuebutton;
	

	public WebElement getContinuebutton() {
		return continuebutton;
	}

	public WebElement getRadiobutton() {
		return radiobutton;
	}

	public WebElement getSelectHotelpage() {
		return SelectHotelpage;
	}

	public WebElement getClicksearch() {
		return clicksearch;
	}

	public WebElement getLocation() {
		return location;
	}

	public WebElement getHotel() {
		return hotel;
	}

	public WebElement getRoom() {
		return room;
	}

	public WebElement getRoomnumber() {
		return roomnumber;
	}

	public WebElement getAdult() {
		return adult;
	}

	public WebElement getChild() {
		return child;
	}
	
	
}
