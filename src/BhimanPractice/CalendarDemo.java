package BhimanPractice;

import java.util.Calendar;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CalendarDemo
{
	public static void main(String[] args)
	{	
		// Automating Joining Date		
		// Get Current Date DD-MM-YYYY		
			Calendar cal = Calendar.getInstance();
			int currentDay = cal.get(Calendar.DAY_OF_MONTH);
			int currentMonth = cal.get(Calendar.MONTH) + 1;
			int currentYear = cal.get(Calendar.YEAR);
			System.out.println("Current Date in Calendar:: " +currentDay+ "-" +currentMonth+ "-" +currentYear);

			String joinDate = "01-04-2020";			//		String joinDate_DD_MM_YYYY[] = joinDate.split("-");
			int firstIndex = joinDate.indexOf("-");		// 01
			int lastIndex = joinDate.lastIndexOf("-");		// 2020
			String day = joinDate.substring(0, firstIndex);
			int joinDay = Integer.parseInt(day);
			String month = joinDate.substring(firstIndex + 1, lastIndex);
		    int joinMonth = Integer.parseInt(month);
		    String year = joinDate.substring(lastIndex + 1, joinDate.length());
		    int joinYear = Integer.parseInt(year);
		    System.out.println("Joining Date to set in Calendar:: " +joinDay+ "-" +joinMonth+ "-" +joinYear);

		    boolean counter = true;
		    int differenceInMonths = 0;
			
		    if ((joinMonth - currentMonth) > 0) {
	            differenceInMonths = joinMonth - currentMonth;
	        } else {
	            differenceInMonths = currentMonth - joinMonth;
	            counter = false;
	        }
		    
			WebElement joiningDate = driver.findElement(By.cssSelector("#joining_date"));
			WebElement prev = driver.findElement(By.xpath("//span[text() = 'Prev']"));
			WebElement next = driver.findElement(By.xpath("//span[text() = 'Next']"));
//			WebElement prev = driver.findElement(By.cssSelector("span.ui-icon.ui-icon-circle-triangle-w"));
//			WebElement next = driver.findElement(By.cssSelector("span.ui-icon.ui-icon-circle-triangle-e"));
			
			joiningDate.clear();
			joiningDate.click();
			
			
	//click on either next or prev icon of calendar 'differenceInMonths' number of times
	        for(int clickOnIcon = 0; clickOnIcon < differenceInMonths; clickOnIcon++) {
	//if the counter value is true, click on next icon else click on prev icon
	            if (counter) {
	            	wait.until(ExpectedConditions.elementToBeClickable(next));
	            	next.click();
	            }else {
	            	wait.until(ExpectedConditions.elementToBeClickable(prev));
	            	prev.click();
	            }
	        }
		
	}
}