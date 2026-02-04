package org.test;

import org.sample.BaseClass;
import org.testng.annotations.Test;

public class Y extends BaseClass {
	
	@Test
	private void tc31() {
		System.out.println("tc31: "+ Thread.currentThread().getId());
		browserLaunch();
		browsermax();
		loadURL("https://adactinhotelapp.com/");

	}
	
	@Test
	private void tc32() {
		System.out.println("tc32: "+ Thread.currentThread().getId());
		browserLaunch();
		browsermax();
		loadURL("https://adactinhotelapp.com/");

	}

}
