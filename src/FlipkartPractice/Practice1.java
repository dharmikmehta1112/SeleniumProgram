package FlipkartPractice;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Practice1 {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.flipkart.com/");
		
		Actions actions = new Actions(driver);
		Action sendEsc = actions.sendKeys(Keys.ESCAPE).build();
		sendEsc.perform();

//		driver.findElement(By.name("q")).sendKeys("one plus");
		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Dell");

		driver.findElement(By.className("L0Z3Pu")).click();
//		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		List<WebElement> items = driver.findElements(By.xpath("//a[@class='_1fQZEK']"));
		System.out.println("No of Items on a page:: " +items.size());

/*		
// Get all product name		
		List<WebElement> productName = driver.findElements(By.xpath("//a[@class='_1fQZEK']/div[2]/div[1]/div[1]"));
		for (int i = 0; i <productName.size(); i++) {
			int count = i+1;
			System.out.println("Product Name " +count+ " :: " +productName.get(i).getText());
		}
				
// Get all product price		
		List<WebElement> prices = driver.findElements(By.xpath("//div[@class='_30jeq3 _1_WHN1']"));
		for (int i = 0; i < prices.size(); i++) {
			String price = prices.get(i).getText();
			price =  price.replaceAll("[^0-9]", "");
			System.out.println("Item price:: " +price);
		}
*/		
		
// Click on nth product from the list
		int nthElement = 10;
//		driver.findElement(By.xpath("//descendant::a[@class='_1fQZEK']["+nthElement+"]")).click();
		
		driver.findElement(By.xpath("//descendant-or-self::a[@class='_1fQZEK']["+nthElement+"]")).click();
		
//		driver.findElement(By.xpath("(//a[@class='_1fQZEK'])["+nthElement+"]")).click();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
