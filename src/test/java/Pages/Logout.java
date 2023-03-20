package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Logout {
	
		WebDriver driver;
		WebDriverWait wait;
		
		public  Logout(WebDriver driver)
		{
			this.driver=driver;
		}
		
		public By Home = By.xpath("//*[@id=\"root\"]/div/div[1]/div[1]/a");
		public By Accounticon = By.xpath("//*[@id=\"customer-tooltip-trigger\"]/span");
		public By Logoutbtn = By.xpath("//*[@id=\"customer-tooltip-content\"]/nav/a[5]");
		public By Arabic = By.xpath("//*[@id=\"root-desktop\"]/header/div[1]/a");
		
		WebElement Account;
		
		public void LogoutandChangeLanguage() throws InterruptedException
		{
			
			driver.findElement(Home).click();
			Account = driver.findElement(Accounticon);
			Actions actions = new Actions(driver);
			actions.moveToElement(Account);
			WebElement Logout = driver.findElement(Logoutbtn);
			actions.moveToElement(Logout);
			actions.click().build().perform();
			Thread.sleep(4000);
			driver.findElement(Arabic).click();

		}
		

}
