package org.test;

import org.sample.BaseClass;
import org.testng.annotations.Test;

public class Z extends BaseClass {

	@Test
	private void tc41() {
		System.out.println("tc41: "+ Thread.currentThread().getId());
		browserLaunch();
		browsermax();
		loadURL("https://adactinhotelapp.com/");

	}
	
	@Test
	private void tc42() {
		System.out.println("tc42: "+ Thread.currentThread().getId());
		browserLaunch();
		browsermax();
		loadURL("https://adactinhotelapp.com/");

	}
	
}
