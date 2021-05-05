package SpiceJet;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class SignUp {

	@Test
	public void verifySignUpForm() {
		WebDriverManager.chromedriver().setup();
		RemoteWebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.spicejet.com/");
		Actions action = new Actions(driver);
		Actions login = action.moveToElement(driver.findElement(By.xpath("//div[@id='smoothmenu1']/descendant::a[contains(text(),'Login / Signup')]")));
		login.build().perform();
		Actions spiceClubMembers = action.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'SpiceClub Members')]")));
		spiceClubMembers.build().perform();
		driver.findElement(By.xpath("//a[contains(text(),'SpiceClub Members')]")).click();
		List<WebElement> allMembersElements = driver.findElements(By.xpath("//div[@id='smoothmenu1']/ul//li[@class='li-login float-right tabres']/ul/li[2]/ul/li/a"));
		for(WebElement e : allMembersElements) {
			String elementTxt = e.getText();
			System.out.println("Text :: " +elementTxt);
		}
		driver.findElement(By.xpath("//div[@id='smoothmenu1']/ul//li[@class='li-login float-right tabres']/ul/li[2]/ul/li[2]/a")).click();
		WebElement title = driver.findElement(By.xpath("//select[contains(@name,'DropDownListTitle')]"));
		Select titleDropDwn = new Select(title);
		titleDropDwn.selectByValue("MR");
		
		WebElement fname = driver.findElement(By.xpath("//input[contains(@name,'TextBoxFirstName')]"));
		fname.clear();
		fname.sendKeys("K K");
		System.out.println("First Name:: " +fname.getAttribute("value"));
		
		WebElement lname = driver.findElement(By.xpath("//input[contains(@name,'TextBoxLastName')]"));
		lname.clear();
		lname.sendKeys("M M");
		System.out.println("Last Name:: " +lname.getAttribute("value"));
		
		WebElement mobileNo = driver.findElement(By.xpath("//input[contains(@name,'TEXTBOXINTLMOBILENUMBER')]"));
		mobileNo.clear();
		mobileNo.sendKeys("999918901");
		System.out.println("Mobile No:: " +mobileNo.getAttribute("value"));
		
		WebElement password = driver.findElement(By.xpath("//input[contains(@name,'PasswordFieldAgentPassword')]"));
		password.clear();
		password.sendKeys("abcd@1234");
		System.out.println("Password:: " +password.getAttribute("value"));
		
		WebElement confirmPassword = driver.findElement(By.xpath("//input[contains(@name,'PasswordFieldPasswordConfirm')]"));
		confirmPassword.clear();
		confirmPassword.sendKeys("abcd@1234");
		System.out.println("Confirm Password:: " +confirmPassword.getAttribute("value"));
		
		WebElement dob = driver.findElement(By.xpath("//input[contains(@name,'TEXTBOXINPUTDOB')]"));
		dob.clear();
		dob.sendKeys("01/01/2000");
		System.out.println("Date of Birth:: " +dob.getAttribute("value"));
		
		WebElement email = driver.findElement(By.xpath("//input[contains(@name,'TextBoxEmail')]"));
		email.clear();
		email.sendKeys("abcd1234@abc.com");
		System.out.println("Email Address:: " +email.getAttribute("value"));
		
		WebElement chkBx = driver.findElement(By.xpath("//input[@id='chkSpiceClubTnC']"));
		chkBx.click();
		
		WebElement submitBtn = driver.findElement(By.xpath("//input[contains(@name,'ButtonSubmit')]"));
		submitBtn.click();
		
	}

}
