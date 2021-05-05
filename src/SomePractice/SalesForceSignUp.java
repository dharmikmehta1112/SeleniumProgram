package SomePractice;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SalesForceSignUp {
	
	public static String browser = "Chrome";
	public static WebDriver driver;

	public static void main(String[] args) {
		if (browser.equalsIgnoreCase("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else
			System.out.println("Invalid Browser name");
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		driver.get("https://www.salesforce.com/in/");
		System.out.println("Parent Page Title: " + driver.getTitle());
		System.out.println("Parent Page URL: " + driver.getCurrentUrl());
		driver.findElement(By.xpath("//span[contains(text(),'Try For Free')]")).click();
//		Window Handles
		String parentwindow  = driver.getWindowHandle();
		System.out.println("Parent Window Handle: " + parentwindow);
		Set<String> windowhandles = driver.getWindowHandles();
		Iterator<String> iterator = windowhandles.iterator();
		String childwindow = null;
		while(iterator.hasNext()) {
			childwindow = iterator.next();
			if(!childwindow.equals(parentwindow)) {
				System.out.println("Child Window Handle: " + childwindow);				
				driver.switchTo().window(childwindow);
				System.out.println("Child Page Title: " + driver.getTitle());
				System.out.println("Child Page URL: " + driver.getCurrentUrl());
			}
		}
		driver.findElement(By.name("UserFirstName")).sendKeys("ABC");
		driver.findElement(By.name("UserLastName")).sendKeys("XYZ");
		driver.findElement(By.name("UserEmail")).sendKeys("abc@xyz.com");
		WebElement jobtitleddown = driver.findElement(By.name("UserTitle"));
		Select jobtitleselect = new Select(jobtitleddown);
		List<WebElement> jobtitlecount = jobtitleselect.getOptions();
		System.out.println("Number of option in Job Title Drop Down: " + jobtitlecount.size());
		for (int i = 1; i < jobtitlecount.size(); i++) {
			jobtitleselect.selectByIndex(i);
			System.out.println(jobtitlecount.get(i).getText());
		}
		driver.findElement(By.name("CompanyName")).sendKeys("MNOP");
		WebElement companyemplddown = driver.findElement(By.name("CompanyEmployees"));
		Select companyempselect = new Select(companyemplddown);
		List<WebElement> companyempcount = companyempselect.getOptions();
		System.out.println("Number of option in Company Employee Drop Down: " + companyempcount.size());
		for (int i = 1; i < companyempcount.size(); i++) {
			companyempselect.selectByIndex(i);
			System.out.println(companyempcount.get(i).getText());
		}
		driver.findElement(By.name("UserPhone")).sendKeys("9876543210");
		WebElement compcountryddown = driver.findElement(By.name("CompanyCountry"));
		Select compcountryselect = new Select(compcountryddown);
		List<WebElement> compcountrycount = compcountryselect.getOptions();
		System.out.println("Number of option in Company Country Drop Down: " + compcountrycount.size());
		compcountryselect.selectByVisibleText("India");
		
//		for (int i = 1; i < compcountrycount.size(); i++) {
//			compcountryselect.selectByIndex(i);
//			compcountrycount.get(i).getText();
//		}

		driver.close();
		
		driver.switchTo().window(parentwindow);
		System.out.println("Parent Page Title: " + driver.getTitle());
		System.out.println("Parent Page URL: " + driver.getCurrentUrl());

		driver.quit();
	}
}
