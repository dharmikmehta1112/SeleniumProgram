package BhimanPractice;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Masters {

//	@Test
	public void createList() {
		int count = 1;
//		System.setProperty("webdriver.chrome.driver", "D:\\Jars\\ChromeDriver\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
//		WebDriver driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver, 10);
		driver.get("http://103.50.162.196/testing");
		driver.manage().window().maximize();
		driver.findElement(By.cssSelector("input#username")).sendKeys("9876543210");
		driver.findElement(By.cssSelector("input#password")).sendKeys("admin");
		driver.findElement(By.cssSelector("button[type='submit']")).click();
		wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("button[class='swal2-confirm styled']")));
		driver.findElement(By.cssSelector("button[class='swal2-confirm styled']")).click();
/*		
		List<WebElement> dashboard_nav_options = driver.findElements(By.cssSelector("body div.main-horizontal-nav nav ul#respMenu span.toggle-none"));
		System.out.println("Dashboard Navigation Options count:: "+dashboard_nav_options.size());
		Iterator<WebElement> nav_itr = dashboard_nav_options.iterator();
		while(nav_itr.hasNext()) {
			WebElement nav_name = nav_itr.next();
			System.out.println("Navigation options" +count+ " :: " + nav_name.getText());
			count++;
		}
*/			
		WebElement masters = driver.findElement(By.cssSelector("body div.main-horizontal-nav nav ul#respMenu li:nth-of-type(2) span.toggle-none"));
		System.out.println("Masters text:: " +masters.getText());
		Actions action =new Actions(driver);
//		action.moveToElement(driver.findElement(By.xpath("//span[text()='Masters']"))).build().perform();
		action.moveToElement(masters).build().perform();
		List<WebElement> masters_options = driver.findElements(By.cssSelector("body div.main-horizontal-nav nav ul#respMenu ul.nav-second-level.nav.flex-column.sub-menu"));		// 4
		Iterator<WebElement> itr = masters_options.iterator();
		while(itr.hasNext()) {
			System.out.println("Tab " +count+ " name in master::" + itr.next().getText());
			count++;
		}
		System.out.println("No of tabs in master:: "+count);
		
//		for (WebElement webElement : options) {
//            System.out.println(webElement.getText());
//        }
	
		
		
		
		
		
		
		
		
		
		
		driver.close();
	}
	
	public static void main(String[] args) {
		new Masters().createList();
	}

}