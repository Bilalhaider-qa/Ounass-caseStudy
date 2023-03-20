package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


public class HomePage {
	
	WebDriver driver;
	
	public  HomePage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	WebDriverWait wait;
	WebElement Signup;
	
String HomeTitle = "OUNASS UAE | The Definitive Home of Luxury";
String Ar_HomeTitle = "";
public By CancelNotification = By.id("wzrk-cancel");
public By AccountIcon = By.xpath("//*[@id=\"customer-tooltip-trigger\"]/span[1]");
public By SignupButton =By.xpath("//*[@id=\"root-desktop\"]/header/div[1]/div/div/a");



public void Vtitle() throws InterruptedException
{
	String ATitle = driver.getTitle(); // Getting title of screen
System.out.print(ATitle);
//Assert.assertEquals(ATitle, HomeTitle); // Asserting title

Thread.sleep(3000);
driver.findElement(CancelNotification).click(); // Clicking on Cancel Notification Button


driver.findElement(AccountIcon).click(); // Clicking on Account icon


wait = new WebDriverWait(driver, Duration.ofSeconds(5));
wait.until(ExpectedConditions.visibilityOfElementLocated(SignupButton));
Signup = driver.findElement(SignupButton);
 Assert.assertTrue(Signup.isDisplayed()); // Asserting Sign-up Button
driver.findElement(SignupButton).click(); // Clicking Sign-up Button


}
}
