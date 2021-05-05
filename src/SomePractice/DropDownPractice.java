package SomePractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DropDownPractice {

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
		driver.get("https://www.seleniumeasy.com/test/basic-select-dropdown-demo.html");
		System.out.println(driver.getTitle());

//		driver.findElement(By.linkText("Demo Website!")).click();
//		System.out.println(driver.getTitle());
//		System.out.println(driver.getCurrentUrl());
//
//		driver.findElement(By.id("btn_basic_example")).click();
//		System.out.println(driver.getTitle());
//		System.out.println(driver.getCurrentUrl());
//		
//		driver.findElement(By.className("list-group-item")).click();
//		System.out.println(driver.getTitle());
//		System.out.println(driver.getCurrentUrl());

// 		Single Option Select in Drop Down List
//		WebElement singledropdown = driver.findElement(By.id("select-demo"));
//		Select singleselect = new Select(singledropdown);
//		singleselect.selectByIndex(2); // Select Monday
//		singleselect.selectByValue("Wednesday"); // Select Wednesday
//		singleselect.selectByVisibleText("Saturday"); // Select Saturday

//		Multiple Option Select in Drop Down List

		WebElement multipledropdown = driver.findElement(By.name("States"));
		Select multipleselect = new Select(multipledropdown);

		multipleselect.selectByValue("California");
		multipleselect.selectByIndex(5);
		List<WebElement> allselect = multipleselect.getAllSelectedOptions();
		System.out.println(allselect.size());
		multipleselect.deselectAll();
		multipleselect.selectByValue("California");
		multipleselect.selectByIndex(5);
		multipleselect.selectByValue("California");
		multipleselect.deselectByIndex(5);
		List<WebElement> allselect1 = multipleselect.getAllSelectedOptions();
		System.out.println(allselect1.size());

//		driver.close();
//		driver.quit();

	}
}