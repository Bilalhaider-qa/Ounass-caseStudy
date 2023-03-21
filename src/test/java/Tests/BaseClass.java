package Tests;



import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Pages.HomePage;
import Pages.Logout;
import Pages.MyAcount_EmailValidations;
import Pages.PaymentMethod;
import Pages.ProductDetails;
import Pages.ProductListing;
import Pages.Shipping;
import Pages.Signup;
import Pages.Wishlist;
import io.netty.util.internal.ThreadLocalRandom;


public class BaseClass {
	
	MyAcount_EmailValidations MA;
	HomePage HP;
	Signup SU;
	ProductListing P;
	ProductDetails PD;
	Shipping Ship;
	PaymentMethod PM;
	Logout lg;
	Wishlist wl;
	
	public ExtentHtmlReporter spark;
	public ExtentReports extent;
	private String ExtentReportName;
	public ExtentTest logger;
	public ExtentHtmlReporter htmlReporter;
	
	public static WebDriver driver;
//	public static WebDriver driver1;
	
	//String Email = "test4+07@tests.com";
	int int_random = ThreadLocalRandom.current().nextInt(); 
	String Email = "Bilal.haider+"+int_random+"@test.com";
	 
	
	String EnURL = "https://www.ounass.ae";
	String ArURL = "https://ar.ounass.ae/";
	
	@BeforeTest
	public void setup()
	
	{
		 extent = new ExtentReports();
		 ExtentReportName=System.getProperty("user.dir") + "/test-output/ExtentReport"+System.currentTimeMillis()+".html";
		 spark = new ExtentHtmlReporter(ExtentReportName);
		 extent.attachReporter(spark);
		 
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--incognito");
	
		driver = new ChromeDriver(options);
	//	driver1 = new ChromeDriver(options);
		driver.get(EnURL);	
		driver.manage().window().maximize();
	}
	
	@Test(priority=1)
	public void HomePagetoReg() throws InterruptedException
	{
		HP = new HomePage(driver);
		HP.Vtitle();
	}
	@Test(priority=2)
	public void Registration() throws InterruptedException
	{
		SU = new Signup(driver,Email);
		SU.Signup1();
	}
	@Test(priority=3)
	public void EmailVerificationInAccount() throws InterruptedException
	{
		MA = new MyAcount_EmailValidations(driver,Email);
		MA.EmailVerification();
	}
	@Test(priority=4)
	public void DisableEmailField() throws InterruptedException
	{
		MA = new MyAcount_EmailValidations(driver,Email);
		MA.EmailFieldDisabled();
	}
	@Test(priority=5)
	public void PLPtoPDP() throws InterruptedException
	{
		P = new ProductListing(driver);
		P.clickandScrollPLP();
	}
	@Test(priority=6)
	public void Add2Bag() throws InterruptedException
	{
		PD = new ProductDetails(driver);
		PD.AddtoBagandVerify();
	}
	@Test(priority=7)
	public void AddShippingAddress() throws InterruptedException
	{
		Ship = new Shipping(driver);
		Ship.AddLocation();
	}
	@Test(priority=8)
	public void AddPaymentMethod() throws InterruptedException
	{
		PM = new PaymentMethod(driver);
		PM.CreditForm();
	}
	@Test(priority=9)
	public void COD_Paypal() throws InterruptedException
	{
		PM = new PaymentMethod(driver);
		PM.CODnPaypal();
	}
	@Test(priority=10)
	public void Wishlist_Validations() throws InterruptedException
	{
		wl = new Wishlist(driver);
		wl.WishlsitValidations();
	}
	@Test(priority=11)
	public void Logout_ChangeLanguage() throws InterruptedException
	{
		lg = new Logout(driver);
		lg.LogoutandChangeLanguage();
	}
	
	/*@Test(priority=11)
	public void Ar_HomePagetoReg() throws InterruptedException
	{
		HP = new HomePage(driver);
		HP.Vtitle();
	}
	@Test(priority=12)
	public void Ar_Registration() throws InterruptedException
	{
		SU = new Signup(driver,Email);
		SU.Signup1();
	}
	@Test(priority=13)
	public void Ar_EmailVerificationInAccount() throws InterruptedException
	{
		MA = new MyAccount(driver,Email);
		MA.EmailVerification();
	}
	@Test(priority=14)
	public void Ar_DisableEmailField() throws InterruptedException
	{
		MA = new MyAccount(driver,Email);
		MA.EmailFieldDisabled();
	}*/ 
	
	
	@AfterMethod
	public void getResult(ITestResult result) throws Exception{
		
		logger=extent.createTest(result.getName());
 if(result.getStatus() == ITestResult.FAILURE)
 {
 logger.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " Test Case Failed"  , ExtentColor.RED));
 logger.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + "Test Case Failed" , ExtentColor.RED));
 String screenshotPath = getScreenShot(driver, result.getName());
 logger.fail("Test Case Failed Snapshot is below" + logger.addScreenCaptureFromPath(screenshotPath));
 }
 
 else if(result.getStatus() == ITestResult.SKIP)
 {
 logger.log(Status.SKIP, MarkupHelper.createLabel(result.getName() + " - Test Case Skipped", ExtentColor.GREY));
 }
 
 else if(result.getStatus() == ITestResult.SUCCESS)
 {
 logger.log(Status.PASS, MarkupHelper.createLabel(result.getName()+ "Test Case PASSED", ExtentColor.GREEN));
 }
	}
 
 public static String getScreenShot(WebDriver driver, String screenshotName) throws IOException {
	 String dateName = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(new Date());
	 TakesScreenshot ts = (TakesScreenshot) driver;
	 File source = ts.getScreenshotAs(OutputType.FILE);
	 // after execution, you could see a folder “FailedTestsScreenshots” under src folder
	 String destination = System.getProperty("user.dir")+"/Screenshots/"+screenshotName + dateName + ".png";
	 File finalDestination = new File(destination);
	 FileUtils.copyFile(source, finalDestination);
	 return destination;
		}

@AfterTest
public void teradown()
{
	//driver.close();
	extent.flush();
	 extent.attachReporter(spark);
	
}

}
