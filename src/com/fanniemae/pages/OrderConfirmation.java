package com.fanniemae.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class OrderConfirmation {
	
	public void getConfirmationText(WebDriver driver,String vExpected){
		String vActual = driver.findElement(By.xpath("html/body/font/h2")).getText();
	    Assert.assertEquals(vExpected, vActual);
}
	

}
