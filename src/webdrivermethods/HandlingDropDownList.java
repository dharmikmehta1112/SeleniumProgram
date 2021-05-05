package webdrivermethods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * De-select method applicable only on multi-select drop down.
 * 
 * @author Dharmik Mehta
 */
public class HandlingDropDownList {

	public static void handlingSingleSelect() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.testingshastra.com");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[text()='Assignments']")).click();
		driver.findElement(By.xpath("//a[text()='DropDown List Assignment']")).click();
		WebElement singleDropDown = driver.findElement(By.xpath("//select[@class='single-select']"));
		Select select = new Select(singleDropDown);
		System.out.println(select.isMultiple() + " selected drop down is not multi-select. It is single select.");
//		select.selectByIndex(12);
//		select.selectByValue("Feb");
		select.selectByVisibleText("December");
	}

	public static void handlingMultiSelect() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.testingshastra.com");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[text()='Assignments']")).click();
		driver.findElement(By.xpath("//a[text()='DropDown List Assignment']")).click();
		WebElement multiDropDown = driver.findElement(By.xpath("//select[@class='multi-select']"));
		Select select = new Select(multiDropDown);
		System.out.println(select.isMultiple() + " selected drop down is multi-select.");
//		select.selectByIndex(2);
//		select.selectByValue("");
		select.selectByVisibleText("Core Java");
		select.selectByVisibleText("Selenium WebDriver");
		select.selectByVisibleText("Selenium Grid");
		select.selectByVisibleText("REST API Automation");
		select.selectByVisibleText("Performance Testing using Jmeter");
// De-select method applicable only on 'Multi Select Drop Down'
		select.deselectByIndex(2);
//		select.deselectByValue("");
		select.deselectByVisibleText("Core Java");
//		select.deselectAll();
	}

	public static void main(String[] args) {
//		handlingSingleSelect();
		handlingMultiSelect();
	}
}