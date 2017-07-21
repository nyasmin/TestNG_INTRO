package com.fanniemae.testng;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fanniemae.pages.SearchResultPage;
import com.fanniemae.pages.CatalogueSearch;
import com.fanniemae.pages.CheckOutPage;
import com.fanniemae.pages.OrderConfirmation;
import com.fanniemae.pages.ShoppingCart;

public class MainTest {
	private WebDriver driver;
	private String baseUrl;
	
	@Test(dataProvider = "testdata_shoppingCart")
	public void End2EndTestingFireFox(String item2Search,String qty, String custName) throws InterruptedException, IOException{
		
		//firefox
		String browserDriver = "webdriver.gecko.driver";
		String browserDriverLocation = "C:\\Users\\Huser\\Desktop\\AllJars\\geckodriver.exe";
		
		//phantom
//		String browserDriver = "phantomjs.binary.path";
//		String browserDriverLocation = "C:\\Users\\Huser\\Desktop\\AllJars\\phantomjs-2.1.1-windows\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe";
//		
		String vExpectedOrderConf = "Thank you for ordering with us!";
		System.setProperty(browserDriver, browserDriverLocation);
		driver = new FirefoxDriver();
		//driver = new PhantomJSDriver();
	    baseUrl = "http://sdettraining.com/";
	    driver.get(baseUrl + "/online/");
	    //captureScreenshot();
	    CatalogueSearch catalogueSearch = new CatalogueSearch();
	    catalogueSearch.searchItem(driver, item2Search);
	    Thread.sleep(3000);
	    //captureScreenshot();
	    SearchResultPage addToCart = new SearchResultPage();
	    addToCart.addItem(driver);
	    Thread.sleep(3000);
	    //captureScreenshot();
	    ShoppingCart shoppingCart = new ShoppingCart();
	    shoppingCart.modifyItem(driver, qty);
	    Thread.sleep(3000);
	    //captureScreenshot();
	    shoppingCart.checkOut(driver);
	    Thread.sleep(3000);
	   // captureScreenshot();
	    CheckOutPage checkOutPage = new CheckOutPage();
	    checkOutPage.getCustomerInfo(driver,custName);
	    checkOutPage.getPaymentInfo(driver);
	    checkOutPage.getShippingInfo(driver, custName);
	    Thread.sleep(3000);
	    //captureScreenshot();
	    checkOutPage.proceedToOrder(driver);
	    Thread.sleep(3000);
	    OrderConfirmation OrderConfirmation = new OrderConfirmation();
	    OrderConfirmation.getConfirmationText(driver,vExpectedOrderConf);
	   // captureScreenshot();
	}
	
	@DataProvider
	  public Object[][] testdata_shoppingCart(){
		  return new Object[][]{
			  new Object[]{"Iphone","2","Adam"},
			  //new Object[]{"TV","3","Ben"},
			  //new Object[]{"Canon","4"},
			  //new Object[]{"Camera","5"},
		  };
		  
	  }
	
//	  public void captureScreenshot() throws IOException {
//
//			File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
//
//			Date d = new Date();
//			String screenshotName = d.toString().replace(":", "_").replace(" ", "_") + ".jpg";
//
//			FileUtils.copyFile(scrFile,
//					new File("C:\\Users\\Huser\\Desktop\\AllJars\\screenshots\\" + screenshotName));
//		
//		}

}
