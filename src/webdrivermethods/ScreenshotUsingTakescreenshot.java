package webdrivermethods;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * TakesScreenshot (I): getScreenshotAs(OutputType target)
 * 
 * @author Dharmik Mehta
 */
public class ScreenshotUsingTakescreenshot {
	
	private void tc_01() {
		String filePath = "D:\\Java Program\\Eclipse\\JavaSeleniumPractice\\Screenshots";
		
		WebDriverManager.chromedriver().setup();
//		WebDriver driver = new ChromeDriver();
		RemoteWebDriver driver = new ChromeDriver();
		driver.get("http://www.amazon.com");
		driver.manage().window().maximize();
		TakesScreenshot ts = (TakesScreenshot) driver;
		File screenshot = ts.getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File(filePath + "\\abc.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		driver.close();
	}
	
	public static void main(String[] args) {
		new ScreenshotUsingTakescreenshot().tc_01();
	}
}