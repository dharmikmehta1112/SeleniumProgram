package webdrivermethods;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Keys: keyPress(int keycode), keyRelease(int keycode)
 * 
 * Mouse: mousePress(int button), mouseRelease(int button), 
 * 		  mouseMove(int x, int y)
 * 
 * KeyEvent and MouseEvent are class in java that consists of different
 * constants for keyboard and mouse actions.
 * 
 * Java - Robot Class (Bad choice for mouse action)
 * 
 * Selenium - Action Class (Good choice for mouse action)
 * 
 * @author Dharmik Mehta
 */
public class HandlingMouseAndKeyboardUsingRobotClass {

	public static void HandleKeyboardUsingRobot() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.myntra.com");
		driver.manage().window().maximize();
		try {
			Robot rb = new Robot();

			rb.keyPress(KeyEvent.VK_TAB);
			rb.keyRelease(KeyEvent.VK_TAB);

//			rb.keyPress(KeyEvent.VK_TAB);
//			rb.keyRelease(KeyEvent.VK_TAB);

			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);

		} catch (AWTException e) {
			System.err.println("Invalid Keyboard Key Selected.");
			e.printStackTrace();
		}
//		driver.close();
	}

	public static void HandleMouseUsingRobot() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://www.myntra.com");
		driver.manage().window().maximize();
		try {
			Robot rb = new Robot();

//			rb.mousePress(MouseEvent.MOUSE_MOVED);
//			rb.mouseRelease(MouseEvent.MOUSE_MOVED);
			rb.mousePress(MouseEvent.MOUSE_WHEEL);

			rb.mouseMove(450, 350);		// mouse hover to 'mens'

		} catch (AWTException e) {
			System.err.println("Invalid Mouse Key Selected.");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
//		HandleKeyboardUsingRobot();
		HandleMouseUsingRobot();
	}
}