package pageObjectDatePicker;

import java.util.Calendar;
import java.util.List;
import java.util.spi.CalendarDataProvider;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import frameWorkClasses.BasePage;

public class DatePickerClass extends BasePage {

	public void setDateFromDatePicker(String desiredDateTime) throws InterruptedException {
		
		//Split the desiredTime to only get the Date part
		String date_MM_dd_yyyy[] = (desiredDateTime.split(" ")[0].split("/"));
		
		// click on the date button
		clickElement(By.cssSelector("button:nth-of-type(2) > .k-button-icon.k-i-calendar.k-icon"));
		
		// find the right arrow element for for future dates
		WebElement rightArrow = driver.findElement(By.cssSelector(".k-i-arrow-60-right.k-icon"));
		
		// find the middle button to click the month year
		WebElement middleButton = driver.findElement(By.cssSelector(".k-header.k-hstack > a:nth-of-type(2)"));
		
		// find the left arrow element for for past dates
		WebElement leftArrow = driver.findElement(By.cssSelector(".k-button-icon.k-i-arrow-60-left.k-icon"));
		// for the date part
		
		// click middle
		Thread.sleep(60);
		middleButton.click();
		Thread.sleep(60);
		rightArrow.click();
		Thread.sleep(60);
		leftArrow.click();
		
		// get the year difference between current year and the desired year
		int yearDiff = Integer.parseInt(date_MM_dd_yyyy[2]) - Calendar.getInstance().get(Calendar.YEAR);
		System.out.println(yearDiff);
		//slecect the desired year
		if (yearDiff != 0) {
			//if you have to move to the next year
			if(yearDiff > 0) {
				for(int i=0;i<yearDiff; i++) {
					System.out.println("YearDiff: " + i);
					rightArrow.click();
				}
			}
			//if you have to move to a previous year
			else if(yearDiff < 0) {
				for(int i = 0;i<(yearDiff*(-1)); i++) {
					System.out.println("YearDiff: " + i);
					leftArrow.click();
				}
			}
		}
		//Get all the months from the calendar and place in a list
		List<WebElement> list_AllMonths = driver.findElements(By.xpath("//div[@id='datetimepicker_dateview']//table//tbody//td"));
		
		// select the desired month
		int desiredMonth = Integer.parseInt(date_MM_dd_yyyy[0]);
		System.out.println(desiredMonth);
		list_AllMonths.get(desiredMonth-1).click();
		
		//get a list of all the days in the selected month
		List<WebElement> list_AllDays = driver.findElements(By.xpath(
				"//div[@id='datetimepicker_dateview']//table//tbody//td[not(contains(@class, 'k-other-month'))]"));
		
		//extract the string day and convert into an int
		int desiredDay  = Integer.parseInt(date_MM_dd_yyyy[1]);
		System.out.println(desiredDay);
				
		// select the desired day
		list_AllDays.get(desiredDay-1).click();
		
		// time part
		// click the time button
		clickElement(By.cssSelector(".k-i-clock"));
		// get a list of all the time
		List<WebElement> allTime = driver.findElements(By.xpath("//ul//li[@role='option']"));
		
		//extract the desired time
		//desiredDateTime = desiredDateTime.split(" ")[1] + " " + desiredDateTime.split(" ")[2];
		desiredDateTime = desiredDateTime.substring(desiredDateTime.indexOf(" ")+1);
		System.out.println("Desired Time is:" + desiredDateTime);
		
		// select the desired time
		//for loop syntax
		// for (statement 1; statement 2; statement 3){
		// statement 1 is executed on time
		// statement 2 condition for executing the code block
		// statement 3 is executed everytime after the code block
		for(WebElement webelement: allTime) {
			if(webelement.getText().equalsIgnoreCase(desiredDateTime)) {
			System.out.println("Selected time: " + webelement.getText());
			System.out.println("Desired time: " + desiredDateTime);
			webelement.click();
		}
			
			//return an error if desiredDateTime is invalid. (not half hour or )
		}
	}
}

