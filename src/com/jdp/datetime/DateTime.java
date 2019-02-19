package com.jdp.datetime;

import java.time.LocalDate;
import java.time.Month;
import java.util.Date;

public class DateTime {
	public static void main(String[] args) {
		Date paySlipDate = new Date();
    paySlipDate.setDate(9);
    paySlipDate.setMonth(11);
    paySlipDate.setYear(2016);
    System.out.println(paySlipDate);
    
    LocalDate localDate = LocalDate.now();
    System.out.println(localDate + " day of week " + localDate.getDayOfWeek() + " day of year " + localDate.getDayOfYear());
    LocalDate nextDate = localDate.plusDays(3);
    System.out.println(nextDate + " day of week " + nextDate.getDayOfWeek() + " day of year " + nextDate.getDayOfYear());
    
    LocalDate from = LocalDate.of(2016, Month.JUNE, 01);
    LocalDate to = LocalDate.of(2016, Month.JUNE, 03);
    int compare = from.compareTo(to);
    System.out.println(compare);
	}
}
