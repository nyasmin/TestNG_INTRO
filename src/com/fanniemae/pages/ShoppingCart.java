package com.fanniemae.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ShoppingCart {
	
	public void modifyItem(WebDriver driver,String qty){
		driver.findElement(By.xpath("html/body/font/form/table/tbody/tr[2]/td[1]/font/input")).clear();
		driver.findElement(By.xpath("html/body/font/form/table/tbody/tr[2]/td[1]/font/input")).sendKeys(qty);
		driver.findElement(By.xpath("html/body/font/form/div/input[2]")).click();		 
	}
	
	public void checkOut(WebDriver driver){
		driver.findElement(By.xpath("(//input[@name='cmdSubmit'])[3]")).click();	 
	}

}
