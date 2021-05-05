package webdrivermethods;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * @author Dharmik Mehta
 */
public class WebDriverBrowserMethods {
	
	public void openChrome() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Jars\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.amazon.com");
		Thread.sleep(2000);
		System.out.println("Title: " + driver.getTitle() + "\nCurrent Url: " + driver.getCurrentUrl());
		driver.get("http://www.google.com");
//		driver.navigate().to("http://www.google.com");
		Thread.sleep(2000);
		System.out.println("Title: " + driver.getTitle() + "\nCurrent Url: " + driver.getCurrentUrl());
		driver.navigate().back();		// amazon
		Thread.sleep(2000);
		System.out.println("Title: " + driver.getTitle() + "\nCurrent Url: " + driver.getCurrentUrl());	
		driver.navigate().forward();		// google
		Thread.sleep(2000);
		System.out.println("Title: " + driver.getTitle() + "\nCurrent Url: " + driver.getCurrentUrl());
		driver.close();
	}
	public static void main(String[] args) throws InterruptedException {
		new WebDriverBrowserMethods().openChrome();
	}
}