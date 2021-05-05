package SomePractice;

import java.time.LocalDate;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SpiceJetAssignment {
	public void verifyStudent() {
		WebDriverManager.chromedriver().setup();
// Launch chrome browser		
		RemoteWebDriver driver = new ChromeDriver();
// Maximize window
		driver.manage().window().maximize();
// Delete all cookies
		driver.manage().deleteAllCookies();		
// Dyanamic Wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
// Navigate to the application URL
		driver.get("https://www.spicejet.com/");
// Click on OneWay radio button of Travel options		
		WebElement oneWayRd = driver.findElement(By.cssSelector("#travelOptions td:nth-child(1) label"));
		boolean flag_oneWayRd = oneWayRd.isSelected();
		oneWayRd.click();
// 	Select Departure city as Bengaluru 
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value='BLR']")).click();
// Select Arrival city as Pune		
		driver.findElement(By.id("ctl00_mainContent_ddl_destinationStation1_CTXT")).click();
		driver.findElement(By.xpath("(//a[@value='PNQ'])[2]")).click();
//	Select Departure date as Sysdate+2
		WebElement departDate = driver.findElement(By.xpath("//input[@id='ctl00_mainContent_txt_Fromdate']"));
		LocalDate locdate = java.time.LocalDate.now();
		int day = locdate.getDayOfMonth() + 2;
		int month = locdate.getMonthValue();
		int year = locdate.getYear();
		String dateVal = day + "-" + month + "-" + year; 
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].setAttribute('value','" +dateVal+ "')", departDate);		
		oneWayRd.click();			// click on anywhere
// Select 5 Adults as passengers
		driver.findElement(By.id("divpaxinfo")).click();
		WebElement adult = driver.findElement(By.id("ctl00_mainContent_ddl_Adult"));
		Select adultCount = new Select(adult);
		adultCount.selectByValue("5");
// Select currency INR	
		WebElement curr = driver.findElement(By.cssSelector("#ctl00_mainContent_DropDownListCurrency"));
		Select currType = new Select(curr);
		currType.selectByIndex(3);
// Select the checkbox for Student
		driver.findElement(By.xpath("//input[@id='ctl00_mainContent_chk_StudentDiscount']")).click();
// Click on Search
		driver.findElement(By.cssSelector("input[id='ctl00_mainContent_btn_FindFlights']")).click();
// Verify that on next page Student is mentioned under Discount field
		String expText = " Student";
		String actText = driver.findElement(By.xpath("//span[contains(text(),'Student')]")).getText();
		if(actText.equals(actText)) {
			System.out.println("Test Verified");
		} else {
			System.out.println("Test Failed");
		}
	}	
	
	public static void main(String[] args) {
		new SpiceJetAssignment().verifyStudent();
	}
}