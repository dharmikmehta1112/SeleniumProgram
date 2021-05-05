package SomePractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SugarCRMDemo {

	public static String browser = "Chrome";
	public static WebDriver driver;

	public static void main(String[] args) {

		if (browser.equals("Firefox")) {
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browser.equals("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else
			System.out.println("Invalid Browser name");
		driver.manage().window().maximize();
		driver.get("https://www.sugarcrm.com/");
		String title = driver.getTitle();
		System.out.println(title);
		driver.findElement(By.xpath("//span[@class='btn btn-primary']")).click();
		System.out.println(driver.getTitle());

		driver.findElement(By.name("firstname")).sendKeys("ABC");
		driver.findElement(By.name("lastname")).sendKeys("PQR");
		driver.findElement(By.name("email")).sendKeys("abc@xyz.com");
		driver.findElement(By.name("phone_work")).sendKeys("9876543210");
		driver.findElement(By.name("title")).sendKeys("MNOP");
		driver.findElement(By.name("account_name")).sendKeys("LMNOP");

//		Single Select Drop Down using Select class
		WebElement ddown = driver.findElement(By.name("employees_c"));
		Select slt = new Select(ddown);

//		Print first selected option
		WebElement firstoption = slt.getFirstSelectedOption();
		System.out.println(firstoption.getText());

		slt.selectByIndex(8);

		slt.selectByValue("level4");

		slt.selectByVisibleText("2,501 - 5,000 employees");

		driver.close();
//		driver.quit();

	}
}
