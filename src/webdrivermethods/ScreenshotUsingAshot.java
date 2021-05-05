package webdrivermethods;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Time;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;
import ru.yandex.qatools.ashot.shooting.ShootingStrategies;
import ru.yandex.qatools.ashot.shooting.ShootingStrategy;

/**
 * @author Dharmik Mehta
 */
public class ScreenshotUsingAshot {
	
	
// Take screenshot as normal like TakeScreenshot(I)
	private void tc_01() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://www.amazon.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		
	}

// Take fullpage screenshot with shooting strategy	
	private void tc_02(String filePath) {
	
//		Date date = new Date() ;
//	    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd_HH-mm-ss");
//	    String fileName = Constants.filePath + dateFormat.format(date) + ".png";

		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://www.myntra.com");
		driver.manage().window().maximize();
		AShot ashot = new AShot();
		ShootingStrategy st = ShootingStrategies.viewportPasting(1500);
		ashot = ashot.shootingStrategy(st);
		Screenshot sc = ashot.takeScreenshot(driver);
		BufferedImage img = sc.getImage();
		try {
			ImageIO.write(img, "PNG", new File(filePath + "\\fullpage"+System.currentTimeMillis()+".png"));
			Thread.sleep(5000);
		} catch (Exception e) {
			System.out.println("File path not found");
			e.printStackTrace();
		} finally {
			driver.close();
		}
	}
	
	public static void main(String[] args) {
		String filePath = "D:\\Java Program\\Eclipse\\JavaSeleniumPractice\\Screenshots";

//		new ScreenshotUsingAshot().tc_01(filePath);
		new ScreenshotUsingAshot().tc_02(filePath);
	}
}
