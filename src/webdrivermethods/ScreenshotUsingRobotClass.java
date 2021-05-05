package webdrivermethods;
import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * @author Dharmik Mehta
 */
public class ScreenshotUsingRobotClass {

	public static void takeScreeshot() {
		System.getProperty("user.dir");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.myntra.com");
		driver.manage().window().maximize();
		String filePath = "D:\\Java Program\\Eclipse\\JavaSeleniumPractice\\Screenshot";
		try {
			Robot rb = new Robot();
			Rectangle rect = new Rectangle();
			rect.setSize(1920, 1080);
			BufferedImage image = rb.createScreenCapture(rect);
			ImageIO.write(image, "PNG", new File(filePath + "\\image.png"));
		} catch (AWTException e) {
			System.out.println("Test Failed");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("File path not found: " + filePath);
			e.printStackTrace();
		}
	}
	
	public static void screenCapture() {
		String path = System.getProperty("user.dir");
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.get("http://www.myntra.com");
		driver.manage().window().maximize();
		try {
			Robot rb = new Robot();
			Rectangle rect = new Rectangle();
			rect.setSize(1920, 1080);
			BufferedImage img = rb.createScreenCapture(rect);
			ImageIO.write(img, "PNG", new File(path+"//Screenshots//screencapture.png"));
			
		} catch (AWTException e) {
			System.err.println("Screen size not match");
			e.printStackTrace();
		} catch (IOException e) {
			System.err.println("File path not found: " +path);
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
//		takeScreeshot();
		screenCapture();
	}
}