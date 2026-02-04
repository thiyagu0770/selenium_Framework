package org.test;

import org.sample.BaseClass;
import org.testng.annotations.Test;

public class X extends BaseClass {
	
	@Test
	private void tc21() {
		System.out.println("tc21: "+ Thread.currentThread().getId());
		browserLaunch();
		browsermax();
		loadURL("https://adactinhotelapp.com/");

	}
	
	@Test
	private void tc22() {
		System.out.println("tc22: "+ Thread.currentThread().getId());
		browserLaunch();
		browsermax();
		loadURL("https://adactinhotelapp.com/");

	}
	

}
