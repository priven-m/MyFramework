package pageObjectDatePicker;

import org.testng.annotations.Test;

public class DatePickersTests {
	
	//create an object of the date picker page
	DatePickerClass dpPage = new DatePickerClass();
	
	@Test
	public void datePickerTest1() throws InterruptedException {
		dpPage.setDateFromDatePicker("10/25/2025 4:00 PM");
	}

}
