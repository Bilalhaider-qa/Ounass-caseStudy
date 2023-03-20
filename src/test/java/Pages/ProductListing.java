package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class ProductListing {
	
	WebDriver driver;
	WebDriverWait wait;
	
		
		public  ProductListing(WebDriver driver)
		{
			this.driver=driver;
		
		}
		
		public By Home = By.xpath("//*[@id=\"root\"]/div/div[1]/div[1]/a");
		public By ShopWomen = By.xpath("//*[@id=\"root-desktop\"]/main/a[1]/div[2]/div");
		public By HomeBanner = By.xpath("//*[@id=\"root-desktop\"]/main/a[1]/div/div/div/img");
		public By FilterCategory = By.xpath("//*[@id=\"root-desktop\"]/main/section[1]/section[1]/ul/li[2]/a/span");
		public By ProductonPLP = By.xpath("//*[@id=\"root-desktop\"]/main/section[2]/ul/li[4]/a/span[1]/img[1]");

		
		String ProductTItle = "Shop Amina Muaddi Green Camelia 105 Slingback Pumps in Satin for WOMEN | Ounass UAE";
		
		
		
		public void clickandScrollPLP() throws InterruptedException
		{
			driver.findElement(Home).click();
			driver.findElement(ShopWomen).click();
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    wait.until(ExpectedConditions.visibilityOfElementLocated(HomeBanner));
			driver.findElement(HomeBanner).click();
			Thread.sleep(5000);
			driver.findElement(FilterCategory).click();
			Thread.sleep(3000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,600)", "");
			
			wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		    wait.until(ExpectedConditions.visibilityOfElementLocated(ProductonPLP));
			driver.findElement(ProductonPLP).click();
			Thread.sleep(3000);
			String ATitle = driver.getTitle(); 
			Assert.assertEquals(ATitle, ProductTItle); 
		}

}
