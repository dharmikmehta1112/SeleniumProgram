package SomePractice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class PNQTech {
	
	public void clickFormForSrQAEngineer() {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		WebDriverWait wait = new WebDriverWait(driver, 20);
		Actions act = new Actions(driver);
		driver.get("http://www.pnqtech.com/");
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		WebElement srqa_eng = driver.findElement(By.cssSelector(".crs_info"));
//		act.moveToElement(srqa_eng).click().build().perform();
		srqa_eng.click();
		wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#requirment10 > div.tcl > button")));
		driver.findElement(By.cssSelector("#requirment10 > div.tcl > button")).click();
		WebElement name = driver.findElement(By.xpath("//*[@id='resumeForm10']/form/div[1]/input"));
		name.sendKeys("Dharmik");		
		driver.findElement(By.xpath("//*[@id='resumeForm10']/form/div[2]/input")).sendKeys("Mehta");
		driver.findElement(By.xpath("//*[@id='resumeForm10']/form/div[3]/input")).sendKeys("dharmik.mehta1112@gmail.com");
		driver.findElement(By.xpath("//*[@id='resumeForm10']/form/div[4]/input")).sendKeys("8087182528");
		
		
		
	}
	
	public static void main(String[] args) {
		new PNQTech().clickFormForSrQAEngineer();
	}
}