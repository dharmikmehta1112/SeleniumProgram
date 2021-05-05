package webdrivermethods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Prompt alert: Used to accept some input from end user. They have 2 button, 1
 * text box and label for text.
 * 
 * public interface Alert: void dismiss(), void accept(), String getText(), void
 * sendKeys(String keysToSend);
 * 
 * @author Dharmik Mehta
 */
public class HandlingAlertPrompt {

	public static void handlePromptAlert() throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.testingshastra.com");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[contains(text(), 'Assignments')]")).click();
//		driver.findElement(By.xpath("//a[contains(text(), 'prompt alert')]")).click();
		driver.findElement(By.linkText("prompt alert".toUpperCase())).click();
//		WebElement element = driver.findElement(By.xpath("//button[text()='Click Me']"));
		WebElement element = driver.findElement(By.xpath("//button[contains(text(), 'Click')]"));
		element.click();
		Alert al = driver.switchTo().alert();
		String alertText = al.getText();
		System.out.println("Alert Text: " + alertText);
		Thread.sleep(5000);
//		al.sendKeys("Admin");
		al.accept();
//		al.dismiss();
		Thread.sleep(5000);
//		al.sendKeys("20");
		al.accept();
//		al.dismiss();
		String text = driver.findElement(By.xpath("//p[@id='demo']")).getText();
		System.out.println("Successful Message: " + text);
	}

	public static void main(String[] args) throws InterruptedException {
		handlePromptAlert();
	}
}