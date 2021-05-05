package BhimanPractice;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AddBrokerAttachFileUsingRobot {
	
	public void fillBrokersFormAndClickSubmit() throws IOException, InterruptedException, AWTException {
		WebDriverManager.chromedriver().setup();
// Launch empty chrome browser
		RemoteWebDriver driver = new ChromeDriver();
// Configure webdriver wait		
		WebDriverWait wait = new WebDriverWait(driver, 10);
//		Create Action instance
		Actions action = new Actions(driver);
// Hit URL
		driver.get("http://103.50.162.196/testing");
// Maximize the browser window		
		driver.manage().window().maximize();
// Entering mobile no	
		WebElement mobileNo = driver.findElement(By.cssSelector("input#username"));
		mobileNo.clear();
		mobileNo.sendKeys("9876543210");
// Entering password
		WebElement password = driver.findElement(By.cssSelector("input#password"));
		password.clear();
		password.sendKeys("admin");
// Click on Login button
		driver.findElement(By.cssSelector("button[type='submit']")).submit();
// Create By instance for OK button
		By okBtn = By.cssSelector("button[class='swal2-confirm styled']");
// Wait till window pop up appear
		wait.until(ExpectedConditions.presenceOfElementLocated(okBtn));
// Click to accept
		driver.findElement(okBtn).click();
// Login successful and move to Index page
// Mouse hover to master
		WebElement masters = driver.findElement(
		By.cssSelector("body div.main-horizontal-nav nav ul#respMenu li:nth-of-type(2) span.toggle-none"));
		System.out.println("Masters text:: " + masters.getText());
		action.moveToElement(masters).build().perform();
// Identify and click on Brokers
		WebElement brokers = driver.findElement(By.cssSelector("body div.main-horizontal-nav nav ul#respMenu ul li:nth-of-type(5)"));
		System.out.println("Brokers text:: " + brokers.getText());
		brokers.click();
// Click on AddBroker button
		driver.findElement(By.cssSelector("#add_btn")).click();
// Started filling the add broker form
		WebElement brokerName = driver.findElement(By.cssSelector("#broker_name"));
		wait.until(ExpectedConditions.visibilityOf(brokerName));
		brokerName.sendKeys("Anil Kapoor");
		driver.findElement(By.cssSelector("#mobile_no")).sendKeys("9876543210");
		driver.findElement(By.cssSelector("#broker_address")).sendKeys("AK 1103, AK MultiPlaza, Ak Marg, 411011");
		driver.findElement(By.cssSelector("#joining_date")).sendKeys("01-04-2020", Keys.TAB);
		Select bgroup = new Select(driver.findElement(By.cssSelector("#blood_group")));
		bgroup.selectByIndex(6);
		Select status = new Select(driver.findElement(By.cssSelector("#status")));
		status.selectByIndex(1);
// Scrolling window
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(0,1000)");
		WebElement submitBtn = driver.findElement(By.cssSelector("input[type='submit']"));
//		wait.until(ExpectedConditions.visibilityOf(submitBtn));
		driver.findElement(By.cssSelector("#bank_name")).sendKeys("Bank of India");
		driver.findElement(By.cssSelector("#account_no")).sendKeys("101010101010");
		driver.findElement(By.cssSelector("#ifsc_code")).sendKeys("1AC2B10SH");

		String basePath = System.getProperty("user.dir");
		
// Attach Resume	
		WebElement res = driver.findElement(By.id("resume"));
		
		action.moveToElement(res).click().build().perform();

		Thread.sleep(2000);

		String res_filePath = basePath + "\\UploadFiles\\Resume.pdf";
		
		StringSelection res_obj = new StringSelection(res_filePath);
		
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(res_obj, null);
		
		Robot rb = new Robot();
		
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
						
// Attach Agreement		
		
		Thread.sleep(2000);

		WebElement agreem = driver.findElement(By.id("agreement"));
		
		action.moveToElement(agreem).click().build().perform();
		
		Thread.sleep(2000);
		
		String agre_filePath = basePath + "\\UploadFiles\\Agreement.pdf";
		
		StringSelection agre_obj = new StringSelection(agre_filePath);
		
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(agre_obj, null);
				
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);

// Attach KYC
		
		Thread.sleep(2000);

		WebElement kc = driver.findElement(By.id("kyc"));
		
		action.moveToElement(kc).click().build().perform();
		
		Thread.sleep(2000);
		
		String kyc_filePath = basePath + "\\UploadFiles\\KYC.pdf";
		
		StringSelection kyc_obj = new StringSelection(kyc_filePath);
		
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(kyc_obj, null);
				
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
	

// Click on Submit		
//		submitBtn.submit();
//		driver.close();
}

	public static void main(String[] args) throws IOException, InterruptedException, AWTException {

		new AddBrokerAttachFileUsingRobot().fillBrokersFormAndClickSubmit();

		}
}