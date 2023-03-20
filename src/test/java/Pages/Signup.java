package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class Signup {
	
WebDriver driver;
String Email;
WebDriverWait wait;
	
	public  Signup(WebDriver driver, String Email)
	{
		this.driver=driver;
		this.Email=Email;
	}
	
	
	
	public By txtFirstName = By.name("firstName");
	public By txtLastName = By.name("lastName");
	public By txtEmail = By.xpath("//*[@id=\"root\"]/div/div[1]/div[3]/div/div[2]/div[2]/div/div/div/div[1]/form/div[2]/input");
	public By txtPassword = By.xpath("//*[@id=\"root\"]/div/div[1]/div[3]/div/div[2]/div[2]/div/div/div/div[1]/form/div[3]/input");
	public By RegisterButton = By.xpath("//*[@id=\"root\"]/div/div[1]/div[3]/div/div[2]/div[2]/div/div/div/div[1]/form/button");
	
	
    String FstName = "Test";
    String LstName = "User";
    
    String Pwd = "Test@123";
	
	public void Signup1() throws InterruptedException 
	{
		//Scrolling
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", "");
		
		//Filling the Info for First name
	    wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(txtFirstName));
	    driver.findElement(txtFirstName).click();
	    driver.findElement(txtFirstName).sendKeys(FstName);
		
	      
		
		//Filling the Info for Last name
		driver.findElement(txtLastName).sendKeys(LstName);
		//Filling the Info for Email		
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(txtEmail));
	    driver.findElement(txtEmail).click();
	    driver.findElement(txtEmail).sendKeys(Email);
		
	  //Filling the Info for Password
	    driver.findElement(txtPassword).click();
	    driver.findElement(txtPassword).sendKeys(Pwd);
	    
	    //Clicking on Registeration
	wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOfElementLocated(RegisterButton));
	driver.findElement(RegisterButton).click();
		Thread.sleep(5000);	
	}
	



}
