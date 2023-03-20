package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.interactions.Actions;



public class ProductDetails {
	
	WebDriver driver;
	WebDriverWait wait;
	
		
		public  ProductDetails(WebDriver driver)
		{
			this.driver=driver;
		
		}
		
		public By Brand = By.xpath("//*[@id=\"root-desktop\"]/main/header/h2/a");
		public By Product = By.xpath("//*[@id=\"root-desktop\"]/main/h1/span");
		public By Price = By.xpath("//*[@id=\"root-desktop\"]/main/div[2]/span[1]");
		public By Colour = By.xpath("//*[@id=\"root-desktop\"]/main/section[1]/ul/li[1]/a/picture/img");
		public By Size = By.id("size-code-select-input");
		public By AddtoWL = By.xpath("//*[@id=\"root-desktop\"]/main/div[6]/button[2]");
		public By AddBagBtn = By.xpath("//*[@id=\"root-desktop\"]/main/div[6]/button[1]");
		public By MiniBag = By.xpath("//*[@id=\"cart-tooltip-trigger\"]/span");
		public By BagBrand = By.xpath("//*[@id=\"root\"]/div/div[1]/div[3]/div[2]/div/div[1]/div[2]/div/div[2]/h3/a");
		public By BagProduct = By.xpath("//*[@id=\"root\"]/div/div[1]/div[3]/div[2]/div/div[1]/div[2]/div/div[2]/h4/a");
		public By BagPrice = By.xpath("//*[@id=\"root\"]/div/div[1]/div[3]/div[2]/div/div[1]/div[2]/div/div[4]/div");
		public By SecureCheckoutBtn = By.xpath("//*[@id=\"root\"]/div/div[1]/div[3]/div[2]/div/div[2]/div[5]/div/div[2]/div[3]/button");
		
		
		//public String ExpBrand;
		String ExpProductName;
		String ExpPrice;
		String ActBrand;
		String ActProductName;
		String ActPrice;
		

		 
		
		public void AddtoBagandVerify() throws InterruptedException
		{
			 
			 String ExpBrand = driver.findElement(Brand).getText();
			 ExpProductName = driver.findElement(Product).getText();
			 
	        driver.findElement(Colour).click();
	        Thread.sleep(3000);
	        ExpPrice = driver.findElement(Price).getText();
	        JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,350)", "");
	        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		    wait.until(ExpectedConditions.visibilityOfElementLocated(Size));
			driver.findElement(Size).click();
		
			Actions keyDown = new Actions(driver); 
			keyDown.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN, Keys.ENTER)).perform();
			wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.elementToBeClickable(AddBagBtn));
			driver.findElement(AddBagBtn).click();    
			
			wait = new WebDriverWait(driver, Duration.ofSeconds(5));
			wait.until(ExpectedConditions.elementToBeClickable(AddBagBtn));
			driver.findElement(AddtoWL).click();  
			Thread.sleep(4000);
			
			
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			js1.executeScript("window.scrollTo(0, 0)");
			Thread.sleep(3000);
			  driver.findElement(MiniBag).click();
			  Thread.sleep(5000);
			  ActBrand = driver.findElement(BagBrand).getText();
			  ActProductName = driver.findElement(BagProduct).getText();
			  ActPrice = driver.findElement(BagPrice).getText();
			  System.out.println(ActPrice);
			  
			  Assert.assertTrue(ActBrand.contains(ExpBrand));
			  System.out.println("Brand on PDP is : "+ExpBrand+" Brand on Cart is : "+ActBrand);
			  Assert.assertTrue(ActProductName.contains(ExpProductName));
			  System.out.println("Product on PDP is : "+ExpProductName+" Brand on Cart is : "+ActProductName);
			  Assert.assertTrue(ActPrice.contains(ExpPrice));
			  System.out.println("Product on PDP is : "+ExpPrice+" Brand on Cart is : "+ActPrice);
			  
			  JavascriptExecutor js2 = (JavascriptExecutor) driver;
			  js2.executeScript("window.scrollBy(0,350)", "");
			  Thread.sleep(2000);
			  driver.findElement(SecureCheckoutBtn).click();
			  
			  

		
		
		}
		
		
		 
		
}


