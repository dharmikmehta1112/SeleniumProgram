package webdrivermethods;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author Dharmik Mehta
 */
public class WindowHandling {
	
	public void handleTwoWindows() {
		WebDriverManager.firefoxdriver().setup();
		RemoteWebDriver driver = new FirefoxDriver();
//		WebDriverManager.chromedriver().setup();
//		System.setProperty("webdriver.chrome.driver", "D:\\Jars\\ChromeDriver\\chromedriver.exe");
//		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("http://testingshastra.com/Assignments/First.html");
		driver.manage().window().maximize();
//		driver.manage().window().fullscreen();
		String firstWindowHandle = driver.getWindowHandle();			
		System.out.println("1st Window Handle: " + firstWindowHandle);
		driver.findElement(By.xpath("//button[@id='btn']")).click();		
		System.out.println("Click on Ok button of 1st Window.");
		Set<String> handles = driver.getWindowHandles();		
		Iterator<String> itr = handles.iterator();				
		String secondWindowHandle = null;						
		while(itr.hasNext()) {	
 			String nextHandle = itr.next();
// 			secondWindowHandle = nextHandle;
// /* 			
			if(!nextHandle.equals(firstWindowHandle)) {			
				secondWindowHandle = nextHandle;				
				break;
			}	
// */
		}
			driver.switchTo().window(secondWindowHandle);
			System.out.println("2nd Window Handle: " + secondWindowHandle);
			driver.findElement(By.xpath("//button[@id='close-btn']")).click();
			System.out.println("Click on Close button of 2nd Window.");
			String msg = driver.findElement(By.xpath("//p[contains(text(), 'assignment')]")).getText();
//			String msg = driver.findElement(By.xpath("//p[text() = 'Congratulation ! You have scucessfully completed the assignment.']")).getText();
			System.out.println("Successfull Message: " + msg);		
	}
	
	public static void main(String[] args) {
		new WindowHandling().handleTwoWindows();
	}
}