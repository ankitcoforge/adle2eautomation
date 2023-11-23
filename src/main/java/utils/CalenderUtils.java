package utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import pageObjects.CalenderPo;

public class CalenderUtils extends CalenderPo {

	utilityClass utils = new utilityClass();

	public String getCurrentDate(int days, String fomat) throws ParseException {
		DateFormat dateFormat = new SimpleDateFormat(fomat);
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DATE, days);
		date = calendar.getTime();
		String datenew = dateFormat.format(date);
		System.out.println(datenew);
		return datenew;
	}

	public void selectDate(String date, String format) throws Exception {

		Calendar calendar = Calendar.getInstance();
		try {
			SimpleDateFormat targetDateFormat = new SimpleDateFormat(format);
			targetDateFormat.setLenient(false);
			Date fomattedTargetDate = targetDateFormat.parse(date);
			calendar.setTime(fomattedTargetDate);
		} catch (Exception e) {
			throw new Exception("Invalid date is provided, please check the input date!");
		}
		int targetMonth = calendar.get(Calendar.MONTH);
		int targetYear = calendar.get(Calendar.YEAR);
		int targetDay = calendar.get(Calendar.DAY_OF_MONTH);

		// June 2023 format
		String currentMonthNYear = utils.text("xpath", currentMonthandYear);
		System.out.println("current month and year: " + currentMonthNYear);
		calendar.setTime(new SimpleDateFormat("MMM yyy").parse(currentMonthNYear));
		int currentMonth = calendar.get(Calendar.MONTH);
		int currentYear = calendar.get(Calendar.YEAR);

		while (currentMonth < targetMonth || currentYear < targetYear) {
			utils.clickfield("xpath", NextArrow);
			currentMonthNYear = utils.text("xpath", currentMonthandYear);
			calendar.setTime(new SimpleDateFormat("MMM yyy").parse(currentMonthNYear));
			currentMonth = calendar.get(Calendar.MONTH);
			currentYear = calendar.get(Calendar.YEAR);
		}
		while (currentMonth > targetMonth || currentYear > targetYear) {
			utils.clickfield("xpath", previousArrow);
			currentMonthNYear = utils.text("xpath", currentMonthandYear);
			calendar.setTime(new SimpleDateFormat("MMM yyy").parse(currentMonthNYear));
			currentMonth = calendar.get(Calendar.MONTH);
			currentYear = calendar.get(Calendar.YEAR);
		}
		if (currentMonth == targetMonth || currentYear == targetYear) {
			utils.clickfield("xpath",
					"//table[@class='mat-calendar-table']//div[contains(text(),'" + targetDay + "')]");
			Thread.sleep(10000);
		} else {
			throw new Exception("Unable to select date due to current and target dates mismatch");
		}

	}
	
	public String covertDateFromOneFormatToOther(String inputDate,String currentFormat, String requiredFormat) throws ParseException {
	DateFormat inputDateFormat = new SimpleDateFormat(currentFormat);
	DateFormat outputDateFormat = new SimpleDateFormat(requiredFormat);
    Date dateNew = inputDateFormat.parse(inputDate);
    String formattedDate = outputDateFormat.format(dateNew);
	System.out.println("formatted new Date-"+formattedDate);
	return formattedDate;
	}
	
	public String calenderTxtbox = "//*[contains(@class,'mat-form-field-infix ng-tns')]";
	public String calenderInPopup = "(//mat-icon[text()='calendar_today'])[2]";
	
	//eg: code format to be used in test cases-calendar click>methods
//	utils.clickfield("xpath", calenderInPopup);
//	String futureDate = calenderUtils.getCurrentDate(2,"MMM/dd/yyyy");
//	calenderUtils.selectDate(futureDate,"MMM/dd/yyyy");
	


}
