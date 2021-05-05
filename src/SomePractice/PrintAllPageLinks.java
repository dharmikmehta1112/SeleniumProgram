package SomePractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PrintAllPageLinks {

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
		System.out.println("Page Title is " + driver.getTitle());
		System.out.println("Page Url is : " + driver.getCurrentUrl());
		driver.findElement(By.xpath("//span[@class='btn btn-primary']")).click();
		System.out.println("Page Title is " + driver.getTitle());
		System.out.println("Page Url is " + driver.getCurrentUrl());

//		By defaults, all Link in a Web page start with an anchor (a) tag with attribute as href.
		List<WebElement> alltags = driver.findElements(By.tagName("a"));
		System.out.println(alltags.size());

		for (int i = 0; i < alltags.size(); i++) {
			System.out.println("Link is " + alltags.get(i).getAttribute("href"));
			System.out.println("Link Text is " + alltags.get(i).getText());
		}

		driver.close();
//		driver.quit();
	}

}
