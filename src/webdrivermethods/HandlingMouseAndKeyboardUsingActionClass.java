package webdrivermethods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Java - Robot Class 
 * Selenium - Action Class
 *
 * @author Dharmik Mehta
 */
public class HandlingMouseAndKeyboardUsingActionClass {

	public static void HandleKeyboardUsingAction() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.myntra.com");
		driver.manage().window().maximize();
		Actions act = new Actions(driver);
		
	}

	public static void HandleMouseUsingAction() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.testingshastra.com");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[text()='Assignments']")).click();
		driver.findElement(By.xpath("//a[text()='Drag And Drop Assignment']")).click();
		Actions act = new Actions(driver);
		WebElement source = driver.findElement(By.xpath("//img[@id='drag1']"));
		act.click();
//		act.clickAndHold();
//		act.moveToElement(source);
//		act.clickAndHold(source);
		WebElement target = driver.findElement(By.xpath("//div[@id='div1']"));
		act.moveToElement(target);
		act.release(source);

//		act.dragAndDrop(source, target);
		act.build().perform();
//		driver.close();
	}

	public static void main(String[] args) {
//		HandleKeyboardUsingAction();
		HandleMouseUsingAction();
	}
}