package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class MyAcount_EmailValidations {
	
WebDriver driver;
String Email;
String readonly;
	
	public  MyAcount_EmailValidations(WebDriver driver, String Email)
	{
		this.driver=driver;
		this.Email=Email;
		
	}
	
	WebDriverWait wait;
	
	public By  AccountIcon = By.xpath("//*[@id=\"customer-tooltip-trigger\"]/span[1]");	
	public By AEmail = By.xpath("//*[@id=\"root\"]/div/div[1]/div[3]/div[2]/div[2]/div[5]/div[1]/div[2]/span[2]");
	public By Edit = By.xpath("//*[@id=\"root\"]/div/div[1]/div[3]/div[2]/div[2]/div[4]/a");
	public By DEmail = By.name("email");
	public By FName = By.name("firstName");
	
	
	
	
	public void EmailVerification() throws InterruptedException
	{
	
		driver.findElement(AccountIcon).click();
		String ActualEmail = driver.findElement(AEmail).getAttribute("outerHTML");
		System.out.println(ActualEmail);
	    Assert.assertTrue(ActualEmail.contains(Email));
		Thread.sleep(5000);	

}
	public void EmailFieldDisabled() throws InterruptedException
	{
		
		driver.findElement(Edit).click();
		WebElement CheckDisable = driver.findElement(DEmail);
		assert !CheckDisable.isEnabled();
		
	

	}
	
}
