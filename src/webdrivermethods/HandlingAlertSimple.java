package webdrivermethods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Simple alert: Used to notify about something to the end user. They have only
 * one button and text area.
 * 
 * public interface Alert: void dismiss(), void accept(), String getText(), void
 * sendKeys(String keysToSend);
 * 
 * @author Dharmik Mehta
 */
public class HandlingAlertSimple {

	public static void handleSimpleAlert() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
		driver.get("http://www.testingshastra.com");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[contains(text(), 'Assignments')]")).click();
		driver.findElement(By.linkText("simple alert".toUpperCase())).click();
//		driver.findElement(By.xpath("//a[contains(text(), 'simple alert')]")).click();
		WebElement element = driver.findElement(By.xpath("//input[@id='user']"));
		element.sendKeys("Admin");
		driver.findElement(By.xpath("//button[text()='Click Me']")).click();
		Alert al = driver.switchTo().alert();
		String alertText = al.getText();
		System.out.println("Alert Text: " + alertText);
		al.accept();
		element.clear();
		element.sendKeys("Admin1234");
	}

	public static void main(String[] args) {
		handleSimpleAlert();
	}
}