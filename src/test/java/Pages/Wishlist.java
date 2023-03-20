package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Wishlist {
	
	WebDriver driver;
	WebDriverWait wait;
	String ExpTitle = "My Wishlist (1)";
	String Title;
	JavascriptExecutor js;
	JavascriptExecutor js1;
	
		
		public  Wishlist(WebDriver driver)
		{
			this.driver=driver;
			
		}
		
		
		public By Wishlisticon = By.xpath("//*[@id=\"wishlist-tooltip-trigger\"]/span");
		public By WishlistTitle = By.xpath("//*[@id=\"root\"]/div/div[1]/div[3]/div/div[2]/h1");
		public By SizeGuide = By.xpath("//*[@id=\"root\"]/div/div[1]/div[3]/div/div[3]/div/div[1]/div[2]/div[1]/button");
		public By CompareSizeDrp = By.id("react-select-SizeGuideV2--value");
		public By CloseSizeGuide = By.xpath("/html/body/div[7]/div/div/button");
		public By ColorDropdown = By.id("react-select-color_215486718--value");
		public By SizeDropdown = By.id("react-select-sizeCode_215486718--value");
		public By AddtoBag = By.xpath("//*[@id=\"root\"]/div/div[1]/div[3]/div/div[3]/div/button[2]");
		public By RemovefromWL = By.xpath("//*[@id=\"root\"]/div/div[1]/div[3]/div/div[3]/div/button[1]");
		
		public void WishlsitValidations() throws InterruptedException
		{
			driver.findElement(Wishlisticon).click();
			Thread.sleep(3000);
		    Title =	driver.findElement(WishlistTitle).getText();
		    Assert.assertTrue(ExpTitle.contains(Title));
		    js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,500)", "");
		    driver.findElement(SizeGuide).click();
		    wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		    wait.until(ExpectedConditions.visibilityOfElementLocated(CompareSizeDrp));
			driver.findElement(CompareSizeDrp).click();
			Actions keyDown = new Actions(driver); 
			keyDown.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN, Keys.ENTER)).perform();
			Thread.sleep(3000);
			driver.findElement(CloseSizeGuide).click();
			//Select Colour
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    wait.until(ExpectedConditions.elementToBeClickable(ColorDropdown));
			driver.findElement(ColorDropdown).click();
			Thread.sleep(2000);
			Actions keyDown1 = new Actions(driver); 
			keyDown1.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN, Keys.ENTER)).perform();
			Thread.sleep(2000);
			//Select Size
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    wait.until(ExpectedConditions.elementToBeClickable(SizeDropdown));
			driver.findElement(SizeDropdown).click();
			Actions keyDown2 = new Actions(driver); 
			keyDown2.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN, Keys.ENTER)).perform();
			Thread.sleep(2000);
			//Add to Bag
			wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		    wait.until(ExpectedConditions.visibilityOfElementLocated(AddtoBag));
		    driver.findElement(AddtoBag).click();
		    Thread.sleep(5000);
		    //Scroll Up
		    js1 = (JavascriptExecutor) driver;
		    js1.executeScript("window.scrollTo(0, 0)");
		    //Remove from Wishlist
		    wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		    wait.until(ExpectedConditions.elementToBeClickable(RemovefromWL));
		    driver.findElement(RemovefromWL).click();
		    

		    
		    
			
			
		}
		
		
		
		

}
