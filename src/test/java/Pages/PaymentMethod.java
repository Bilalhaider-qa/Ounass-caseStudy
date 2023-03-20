package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentMethod {
	
	WebDriver driver;
	WebDriverWait wait;
	
		
		public  PaymentMethod(WebDriver driver)
		{
			this.driver=driver;
		
		}
		
		public By Home = By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[1]/a");
		public By txtNameOnCard = By.id("nameOnCard");	
		public By txtCardNumber = By.id("cardNumber");
		public By ExpMonth = By.xpath("//*[@id=\"react-select-expiryMonth--value\"]/div[1]");
		public By ExpYear = By.xpath("//*[@id=\"react-select-expiryYear--value\"]/div[1]");
		public By txtCVV = By.id("cvc");
		public By ChkSaveCard = By.id("storePaymentToken");
		public By PaypalBtn = By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[3]/div/div[1]/div/div/div[1]/button[2]/div");
		public By CODBtn = By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[3]/div/div[1]/div/div/div[1]/button[3]/div");
		
		String NameonCard = "Test";
		String CardNumber = "4005550000000001";
		String CVV = "123";
		String Month ="5 - May";
		String Year ="2025";
		
		public void CreditForm() throws InterruptedException
		{
			wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		    wait.until(ExpectedConditions.visibilityOfElementLocated(txtNameOnCard));
			driver.findElement(txtNameOnCard).sendKeys(NameonCard);
			driver.findElement(txtCardNumber).sendKeys(CardNumber);
			Thread.sleep(4000);
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    wait.until(ExpectedConditions.elementToBeClickable(ExpMonth));
			driver.findElement(ExpMonth).click();
			Actions keyDown = new Actions(driver); 
			keyDown.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN,Keys.DOWN, Keys.ENTER)).perform();
			wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		    wait.until(ExpectedConditions.elementToBeClickable(ExpYear));
			driver.findElement(ExpYear).click();
			keyDown.sendKeys(Keys.chord(Keys.DOWN, Keys.DOWN,Keys.DOWN, Keys.ENTER)).perform();
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,350)", "");
			Thread.sleep(2000);
			driver.findElement(txtCVV).sendKeys(CVV);
			driver.findElement(ChkSaveCard).click();
			Thread.sleep(5000);
			
			
		}
		public void CODnPaypal() throws InterruptedException
		{
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollTo(0, 0)");
			Thread.sleep(3000);
			driver.findElement(PaypalBtn).click();
			Thread.sleep(2000);
			driver.findElement(CODBtn).click();
			Thread.sleep(2000);
			driver.findElement(Home).click();
			Thread.sleep(4000);
			
			
		}
	
		
		


}
