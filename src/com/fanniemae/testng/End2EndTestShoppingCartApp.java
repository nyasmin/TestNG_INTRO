package com.fanniemae.testng;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class End2EndTestShoppingCartApp {
	
	private WebDriver driver;
	private String baseUrl;
	
  @Test (enabled=false, dataProvider = "testdata_shoppingCart")
  public void tc_End2EndTestingShoppingCartApp(String item2Search,String Qty,String custName,String custCity,String custState) throws InterruptedException {
	  
	  //	String item2Search = "TV";
	  	String vExpected = "Thank you for ordering with us!";
		String vActual;
		int numOfRows = 3;
	    System.out.println("Code for the testcase for shopping cart");
	    System.setProperty("webdriver.gecko.driver", "C:\\Users\\Huser\\Desktop\\AllJars\\geckodriver.exe");
		driver = new FirefoxDriver();
	    baseUrl = "http://sdettraining.com/";
	    driver.get(baseUrl + "/online/");
	    // Search Product
	   // for(int i=0; i<numOfRows;i++){
	    driver.findElement(By.name("txtSearch")).clear();
	    //driver.findElement(By.name("txtSearch")).sendKeys("Iphone");
	    driver.findElement(By.name("txtSearch")).sendKeys(item2Search);
	    driver.findElement(By.id("Go")).click();
	   // }
	    Thread.sleep(3000);
	    //Adding to the cart
	    driver.findElement(By.xpath("html/body/font/table[1]/tbody/tr[1]/td[3]/a/img")).click();
	    Thread.sleep(3000);
	    // Checkout cart
	    driver.findElement(By.xpath("(//input[@name='cmdSubmit'])[3]")).click();
	    driver.findElement(By.name("txtCustomerName")).clear();
	    driver.findElement(By.name("txtCustomerName")).sendKeys("Nilofar");
	    driver.findElement(By.name("txtAddress")).clear();
	    driver.findElement(By.name("txtAddress")).sendKeys("123 Reston");
	    driver.findElement(By.name("txtCity")).clear();
	    driver.findElement(By.name("txtCity")).sendKeys("Reston");
	    driver.findElement(By.name("txtPhone")).clear();
	    driver.findElement(By.name("txtPhone")).sendKeys("1237888234");
	    
	    // Payment info
	    driver.findElement(By.name("optPaymentType")).click();
	    driver.findElement(By.name("txtAcctNo")).clear();
	    driver.findElement(By.name("txtAcctNo")).sendKeys("123456789123");
	    driver.findElement(By.name("txtCVV2No")).clear();
	    driver.findElement(By.name("txtCVV2No")).sendKeys("123");
	    driver.findElement(By.name("txtExpDate")).clear();
	    driver.findElement(By.name("txtExpDate")).sendKeys("12/2018");
	   
	    
	    //shipping info
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
	    driver.findElement(By.xpath("(//input[@name='cmdSubmit'])[3]")).click();
	    // Confirmation
	    vActual = driver.findElement(By.xpath("html/body/font/h2")).getText();
	    Assert.assertEquals(vExpected, vActual);
  }
  
  @Test(enabled = false)
  public void tc_End2EndTestingRegressionShoppingCartApp() {
	  System.out.println("Code for the testcase for shopping cart");
  }
  
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("All Intisialization should happen here");
  }

  @AfterMethod
  public void afterMethod() {
	  System.out.println("All clean up here");
  }
  
  @DataProvider
  public Object[][] testdata_shoppingCart(){
	  return new Object[][]{
		  new Object[]{"Iphone","2","Adam","Miami Beach","FL"},
		  new Object[]{"TV","3","Ben","New York","NY"},
		  new Object[]{"Canon","4","Cho","Dallas","TX"},
		  new Object[]{"Camera","5","Den","Boston","FL"},
	  };
	  
  }
  
  public void captureScreenshot() throws IOException {

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		Date d = new Date();
		String screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";

		FileUtils.copyFile(scrFile,
				new File("C:\\Users\\Huser\\Desktop\\AllJars\\screenshots\\" + screenshotName));

	
	//	 File RateLookupScreenShot =    ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
  //     FileUtils.copyFile(RateLookupScreenShot, new File ("C:\\071717\\D6\\D7_CrossBrowserTesting\\screenshots\\test.jpg"));
	
	
	
	}
  
  @Test
	public void test_PhantomJSDriver_ShoppingCartCompleteTestCase() throws Exception {
	  File file = new File("C:/Users/Huser/Desktop/AllJars/phantomjs-2.1.1-windows/phantomjs-2.1.1-windows/bin/phantomjs.exe");				
	  System.setProperty("phantomjs.binary.path", file.getAbsolutePath());		
	  driver = new PhantomJSDriver();	
	  driver.get("http://www.google.com");         
	  WebElement element = driver.findElement(By.name("q"));	
	  element.sendKeys("Donald Trump");	
	  Thread.sleep(3000);
	  captureScreenshot();
	  element.submit();         			
	  System.out.println("PhantomJSDriver Browser: Page title is: " + driver.getTitle());		
	  driver.quit();			
}	

}
