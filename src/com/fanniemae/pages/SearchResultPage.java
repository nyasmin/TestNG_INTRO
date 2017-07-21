package com.fanniemae.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultPage {
	
	public void addItem(WebDriver driver){
		 driver.findElement(By.xpath("html/body/font/table[1]/tbody/tr[1]/td[3]/a/img")).click();
		 
	}

}
