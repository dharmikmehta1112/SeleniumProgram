package SomePractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownOptions {

	public static String browser = "Chrome";
	public static WebDriver driver;

	public static void main(String[] args) {

		if (browser.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else
			System.out.println("Invalid Browser name");
		driver.manage().window().maximize();
		driver.get("https://www.sugarcrm.com/");
		System.out.println("Page title is " + driver.getTitle());
		System.out.println("Page URL is " + driver.getCurrentUrl());

		driver.findElement(By.xpath("//span[@class='btn btn-primary']")).click();
		System.out.println("Page title is " + driver.getTitle());
		System.out.println("Page URL is " + driver.getCurrentUrl());

		List<WebElement> allopt = driver.findElements(By.tagName("option"));
		System.out.println("Number of option tags in web page are " + allopt.size());

		for (int i = 0; i < allopt.size(); i++) {
			System.out.println("Option tag text is " + allopt.get(i).getText());
		}

		driver.close();
//		driver.quit();
	}
}
