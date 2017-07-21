package com.fanniemae.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CatalogueSearch {
	
	public void searchItem(WebDriver driver, String item2Search){
		 driver.findElement(By.name("txtSearch")).clear();
		 driver.findElement(By.name("txtSearch")).sendKeys(item2Search);
		 driver.findElement(By.id("Go")).click();
	}

}
