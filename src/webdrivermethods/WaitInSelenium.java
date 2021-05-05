package webdrivermethods;

import java.time.Duration;
import java.util.Collection;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Wait(I) - 2 Types (Implicit Wait & Explicit Wait)
 * public until(ExpectedConditions isTrue)	--> ExpectedConditions(C) & ExpectedCondition(I)
 * 
 * 1) Implicit Wait
 * 2) Explicit Wait (2 types: FluentWait(C) & WebDriverWait(C))
 * FluentWait(C) contains all methods & WebDriverWait(C) contains its constructor.
 * 
 * public class FluentWait implements Wait
 * 1) public FluentWait withTimeout(Duration timeout) --> Sets how long to wait for the evaluated condition to be true.
 * 2) public FluentWait withMessage(final String message) --> Sets displayed the message when time expires.
 * 3) public FluentWait pollingEvery(Duration interval) --> Sets how often the condition should be evaluated.
 * 4) public FluentWait ignoreAll(Collection types) --> ignore all exception mention in this Collection types.
 * 5) public FluentWait ignoring(FirstException.class, SecondException.class ....)
 * 
 * public class WebDriverWait extends FluentWait
 * 
 * @author Dharmik Mehta
 */
public class WaitInSelenium {
	
	public void explicitWaitWithPolling() {
		System.setProperty("webdriver.chrome.driver", "D:\\Jars\\ChromeDriver\\chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
// Configure Implicit Wait
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

// Configure Explicit Wait
		FluentWait wait = new FluentWait(driver);
		wait.withTimeout(Duration.ofSeconds(10));
		wait.pollingEvery(Duration.ofMillis(500));
		wait.withMessage("Explict Waiting....");
		wait.ignoring(TimeoutException.class);

// WebDriverWait
//		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds, sleepInMillis);
		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[contains(text(), 'Mobiles')]")).click();
		//a[@href="/mobile-phones/b/?ie=UTF8&node=1389401031&ref_=nav_cs_mobiles"]
		//a[@href='/mobile-phones/b/?ie=UTF8&node=1389401031&ref_=nav_cs_mobiles']
		driver.navigate().back();
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//a[contains(text(), \"Today's Deals\")]")));
		driver.findElement(By.xpath("//a[contains(text(), \"Today's Deals\")]")).click();
		driver.navigate().back();
//		driver.quit();
	}
	
	public static void main(String[] args) {
		new WaitInSelenium().explicitWaitWithPolling();
	}
}