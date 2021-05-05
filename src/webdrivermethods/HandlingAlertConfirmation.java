package webdrivermethods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Confirmation Box alert: Used to confirm the action which is performed by the
 * end user earlier. They may have 2 buttons and text area.
 * 
 * public interface Alert: void dismiss(), void accept(), String getText(), void
 * sendKeys(String keysToSend);
 * 
 * @author Dharmik Mehta
 */
public class HandlingAlertConfirmation {

	public static void handleConfirmBoxAlert() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.testingshastra.com");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[contains(text(), 'Assignments')]")).click();
//		driver.findElement(By.xpath("//a[contains(text(), 'confirmation alert')]")).click();
		driver.findElement(By.linkText("confirmation alert".toUpperCase())).click();
//		WebElement element = driver.findElement(By.xpath("//button[text()='Click Me']"));
		WebElement element = driver.findElement(By.xpath("//button[contains(text(), 'Click')]"));
		element.click();
		Alert al = driver.switchTo().alert();
		String alertText = al.getText();
		System.out.println("Alert Text: " + alertText);
		al.accept();
//		al.dismiss();
		String text = driver.findElement(By.xpath("//p[@id='demo']")).getText();
		System.out.println("Successful Message: " + text);
	}

	public static void main(String[] args) {
		handleConfirmBoxAlert();
	}
}