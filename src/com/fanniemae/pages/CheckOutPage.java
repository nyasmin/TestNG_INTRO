package com.fanniemae.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckOutPage {
	
	public void getCustomerInfo(WebDriver driver,String custName){
			driver.findElement(By.name("txtCustomerName")).clear();
		    driver.findElement(By.name("txtCustomerName")).sendKeys(custName);
		    driver.findElement(By.name("txtAddress")).clear();
		    driver.findElement(By.name("txtAddress")).sendKeys("123 Reston");
		    driver.findElement(By.name("txtCity")).clear();
		    driver.findElement(By.name("txtCity")).sendKeys("Reston");
		    driver.findElement(By.name("txtPhone")).clear();
		    driver.findElement(By.name("txtPhone")).sendKeys("1237888234"); 
	}
	
	public void getPaymentInfo(WebDriver driver){
			driver.findElement(By.name("optPaymentType")).click();
		    driver.findElement(By.name("txtAcctNo")).clear();
		    driver.findElement(By.name("txtAcctNo")).sendKeys("123456789123");
		    driver.findElement(By.name("txtCVV2No")).clear();
		    driver.findElement(By.name("txtCVV2No")).sendKeys("123");
		    driver.findElement(By.name("txtExpDate")).clear();
		    driver.findElement(By.name("txtExpDate")).sendKeys("12/2018");
	}
	
	public void getShippingInfo(WebDriver driver, String custName){
			driver.findElement(By.name("txtshipCustomerName")).clear();
		    driver.findElement(By.name("txtshipCustomerName")).sendKeys(custName);
		    driver.findElement(By.name("txtshipAddress")).clear();
		    driver.findElement(By.name("txtshipAddress")).sendKeys("123 Reston");
		    driver.findElement(By.name("txtshipCity")).clear();
		    driver.findElement(By.name("txtshipCity")).sendKeys("Reston");
		    driver.findElement(By.name("txtshipState")).clear();
		    driver.findElement(By.name("txtshipState")).sendKeys("va");
		    driver.findElement(By.name("txtshipZIP")).clear();
		    driver.findElement(By.name("txtshipZIP")).sendKeys("75235");
		    driver.findElement(By.name("txtState")).clear();
		    driver.findElement(By.name("txtState")).sendKeys("VA");
		    driver.findElement(By.name("txtZIP")).clear();
		    driver.findElement(By.name("txtZIP")).sendKeys("75235");
		    	 
	}
	
	public void proceedToOrder(WebDriver driver){
		 	driver.findElement(By.xpath("(//input[@name='cmdSubmit'])[3]")).click();
	}

}
