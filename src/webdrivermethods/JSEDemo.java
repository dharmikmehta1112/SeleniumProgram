package webdrivermethods;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author Dharmik Mehta
 */
public class JSEDemo {

	private void tc_01() {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.get("https://ijmeet.com/");
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("document.querySelector(\"#navbarContent > ul > li:nth-child(4) > a\").click()");
		jse.executeScript("history.go(0)");			// refresh a window
		
	}
	
	private void tc_02() {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.get("");
//		window.scrollBy(0,1000);
		
	
	}
	public static void main(String[] args) {
		new JSEDemo().tc_01();
//		new JSEDemo().tc_02();
	}
}
