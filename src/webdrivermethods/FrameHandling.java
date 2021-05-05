package webdrivermethods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * WebDriver frame(int index): Select a frame by its (zero-based) index.
 * 
 * WebDriver frame(String nameOrId): Select a frame by its name or ID.
 * 
 * WebDriver frame(WebElement frameElement): Select a frame using its previously located WebElement.
 * 
 * WebDriver parentFrame(): Change focus to the parent context. If the current context is the top level browsing context, 
 * 							the context remains unchanged.
 * 
 * WebDriver defaultContent(): Selects either the first frame on the page, or the main document when a page contains iframes.
 * 
 * @author Dharmik Mehta
 */
public class FrameHandling {

	public static void inlineFrameHandling() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.testingshastra.com");
		driver.manage().window().maximize();
//		driver.findElement(By.xpath("//a[@text() = 'Assignments']")).click();
//		driver.findElement(By.xpath("//a[contains(text(), 'Assignments')]")).click();
		driver.findElement(By.linkText("Assignments".toUpperCase())).click();
		driver.findElement(By.linkText("Frame Handling Demo".toUpperCase())).click();
		driver.switchTo().frame(0);
		driver.findElement(By.name("uname")).sendKeys("admin");
		driver.switchTo().frame(0);
		driver.findElement(By.name("pass")).sendKeys("admin123");
		driver.switchTo().defaultContent();			// switch to DOM of current <html>
//		driver.switchTo().parentFrame();			// switch to parent frame of current frame
		driver.switchTo().frame(1);
		driver.findElement(By.className("btn-login")).click();
		String text = driver.findElement(By.xpath("//p[text()='Congratulation ! You have scucessfully completed the assignment.']")).getText();
		System.out.println("Successful Message: " + text);
		driver.close();
	}

	public static void main(String[] args) {
		inlineFrameHandling();
	}
}