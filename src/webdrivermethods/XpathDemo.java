package webdrivermethods;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

/**
 * All the hyperlinks on a web page can be indentified using Link Text.
 * The links on a web page can be determined with the help of anchor tag (<a>).
 * The anchor tag is used to create the hyperlinks on a web page and the text 
 * between opening and closing of anchor tags constitutes the link text (<a>Some Text</a>).
 * 
 * <tag-name> --> <a> - Defines a hyperlink
 * 				  <h1> to <h6> -- Defines HTML headings
 *                <p> -- Defines a paragraph
 *                <br> -- Inserts a single line break
 *                <img> -- Defines an image
 *                <label> - Defines a label for an <input> elements
 *                <textarea> -- Defines a multiline input control (text area)
 *				  <button> -- Defines a clickable button
 *				  <select> -- Defines a drop-down list
 *				  <optgroup> -- Defines a group of related options in a drop-down list
 *				  <option> -- Defines an option in a drop-down list
 *
 * attribute --> id, class, name, src, href
 * 
 * //<tag-name>[@attribute = 'value']
 * 
 * //<tag-name>[@attribute1 = 'value1' or/and @attribute2 = 'value2']
 * 
 * //<tag-name>[text() = 'value']
 * 
 * //<tag-name>[contains(@attribute, 'value')]
 * 
 * //<tag-name>[contains(text(), 'value')]
 * 
 * //<tag-name>[starts-with(@attribute = 'value')]
 *
 * //<tag-nameA>[contains(@attribute, 'value')]//<axes>::<tag-nameB>
 * 
 * @author Dharmik Mehta
 */
public class XpathDemo {
	
	public void relativeXpath() throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "D:\\Jars\\ChromeDriver\\chromedriver.exe");
		RemoteWebDriver driver = new ChromeDriver();
//		WebDriver driver = new ChromeDriver();
		driver.get("http://www.shutterfly.com");
		Thread.sleep(2000);
		driver.manage().window().maximize();
		System.out.println("Title: " + driver.getTitle() + "\nCurrent Url: " + driver.getCurrentUrl());
//		driver.findElement(By.className("overlay-modal-close")).click();
		driver.findElement(By.xpath("//*[@src='https://cdn.staticsfly.com/i/ui/icon-close.png']")).click();
		driver.findElement(By.xpath("//*[@id='18970']")).click();
		driver.navigate().back();
		
// //span [@class='cat-item-text']
		
//		driver.quit();
	}
	
	public static void main(String[] args) throws InterruptedException {
		
		XpathDemo x = new XpathDemo();
		x.relativeXpath();

	}
}