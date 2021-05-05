package CompanyIQ;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomationPractice {
		
	private static Logger LOG = Logger.getLogger(AutomationPractice.class);
	private static String expected_uri, actual_uri;
		
	@Test
	public void test_101() {
		
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		
		LOG.info("Maximize browser window.");
		driver.manage().window().maximize();
		
		LOG.info("Implictly waiting 20 seconds for page load.");
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
		WebDriverWait wait = new WebDriverWait(driver, 5);
		
		JavascriptExecutor jse = driver;
		
		LOG.info("Opening Web portal URI.");
		driver.get("http://automationpractice.com/index.php");
		
		WebElement signInBtn = driver.findElement(By.className("login"));
		LOG.info("Checking Sign in button is visible or not.");
		if(signInBtn.isDisplayed()) {
			LOG.info("Clicking on Sign in button.");
			signInBtn.click();
		}
// wait		
		WebElement emailTxtBx = driver.findElement(By.id("email_create"));
		jse.executeScript("window.scrollBy(0, 300)","");
		
		LOG.info("Clearing initial text from email address field.");
		if(emailTxtBx.isDisplayed()) {			
			emailTxtBx.clear();
			LOG.info("Entering valid email address on text box of create an account.");
			emailTxtBx.sendKeys("dharmik.mehta1112@gmail.com");
		}
		
		WebElement createBtn = driver.findElement(By.id("SubmitCreate"));
		LOG.info("Checking Create an account button is visible or not.");
		if(createBtn.isDisplayed()) {			
			LOG.info("Clicking on Create an account button.");
			createBtn.click();
		}
// wait		
		LOG.info("Filling Personal Information");
		jse.executeScript("window.scrollTo(0,500)");
		jse.executeScript("arguments[0].scrollIntoView", null)
		WebElement title = driver.findElement(By.id("id_gender1"));
		wait.until(ExpectedConditions.visibilityOf(title));
		title.click();
		driver.findElement(By.id("customer_firstname")).sendKeys("Dharmik");
		jse.executeScript("window.scrollBy(0,1000)");
		WebElement fname = driver.findElement(By.id("firstname"));
		wait.until(ExpectedConditions.visibilityOf(fname));		
		driver.findElement(By.id("customer_lastname")).sendKeys("Mehta");
		driver.findElement(By.id("passwd")).sendKeys("test@123");
		WebElement dob_days = driver.findElement(By.id("days")); 
		Select day = new Select(dob_days);
		day.selectByValue("1");
		WebElement dob_months = driver.findElement(By.id("months")); 
		Select month = new Select(dob_months);
		month.selectByValue("1");
		WebElement dob_years = driver.findElement(By.id("years")); 
		Select year = new Select(dob_years);
		year.selectByValue("2021");
		driver.findElement(By.id("newsletter")).click();
		driver.findElement(By.id("optin")).click();
		LOG.info("Filling Your Address Info.");
		fname.sendKeys("Dharmik");
		
*/		
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
			
//		driver.close();
		}

}
