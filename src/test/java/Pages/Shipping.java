package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Shipping {
	WebDriver driver;
	WebDriverWait wait;
	
		
		public  Shipping(WebDriver driver)
		{
			this.driver=driver;
		
		}
		
		public By txtSearchAddress = By.id("map-autocomplete-input");
		public By AddressSuggestion = By.xpath("//*[@id=\"map-autocomplete-list\"]/li[1]");
		public By ConfirmLocation = By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[3]/div[1]/form/section[1]/div/div/div[2]/button[2]");
		public By txtFlatNo = By.id("additionalInformation");
		public By txtPhoneNo = By.id("mobileNumber");
		public By Checkbox = By.id("isDefault");
		public By ShippingMethod = By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[3]/div[1]/form/section[2]/div[2]");
		public By PackageOption = By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[3]/div[1]/form/section[3]/div/div[2]/label/div");
		public By Continue = By.xpath("//*[@id=\"root\"]/div/div[1]/div/div[3]/div[1]/form/button");
		
		
		String Location = "Duabi internaional Airport";
		String FlatNumber = "Apartment 2101";
		String PhoneNO = "556677889";
		
		public void AddLocation() throws InterruptedException
		{
			driver.findElement(txtSearchAddress).click();
			driver.findElement(txtSearchAddress).sendKeys(Location);
			Thread.sleep(2000);
			driver.findElement(AddressSuggestion).click();
			Thread.sleep(2000);
			driver.findElement(ConfirmLocation).click();
			Thread.sleep(5000);
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,600)", "");
			driver.findElement(txtFlatNo).sendKeys(FlatNumber);
			driver.findElement(txtPhoneNo).sendKeys(PhoneNO);
			driver.findElement(Checkbox).click();
			js.executeScript("window.scrollBy(0,600)", "");
			Thread.sleep(2000);
			driver.findElement(ShippingMethod).click();
			driver.findElement(PackageOption).click();
			js.executeScript("window.scrollBy(0,600)", "");
			driver.findElement(Continue).click();
			
			
			
		}
		


}
