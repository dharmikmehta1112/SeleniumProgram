package BhimanPractice;

import java.time.LocalDate;

public class DateSample {
	
	public static void main(String[] args) {

		LocalDate locdate = java.time.LocalDate.now();
		int day = locdate.getDayOfMonth();
		System.out.println(day);
		int dayPlusTwo = day + 2;
		System.out.println(dayPlusTwo);
		int month = locdate.getMonthValue();
		System.out.println(month);
		int year = locdate.getYear();
		System.out.println(year);
		
		String date = day + "-" + month + "-" + year; 
		System.out.println(date);
		
		String datePlusTwo = dayPlusTwo + "-" + month + "-" + year; 
		System.out.println(datePlusTwo);
		
		
	}

}
