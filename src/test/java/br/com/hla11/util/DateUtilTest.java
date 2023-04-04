package br.com.hla11.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class DateUtilTest {
	
	private static Date date1;
	private static Date date2;
	private static Date date3;
	private static Date date4;
	
	@BeforeAll
	public static void setup() {
		date1 = new GregorianCalendar(2000, Calendar.JANUARY, 1).getTime();
		date2 = new GregorianCalendar(2000, Calendar.JANUARY, 15).getTime();
		date3 = new GregorianCalendar(2000, Calendar.JANUARY, 30).getTime();
		date4 = new GregorianCalendar(2002, Calendar.JANUARY, 1).getTime(); 
	}
	
	@Test 
	public void testAddDays() {
		Date newDate = DateUtil.addDays(date1, 14);
		assertEquals(date2, newDate);
	}
	
	@Test 
	public void testRemoveDays() {
		Date newDate = DateUtil.removeDays(date3, 29);
		assertEquals(date1, newDate);
	}
	
	@Test 
	public void testCountDaysBetween() {
		assertEquals(14, DateUtil.countDaysBetween(date1, date2));
		assertEquals(15, DateUtil.countDaysBetween(date2, date3));
		assertEquals(29, DateUtil.countDaysBetween(date1, date3));
	}
	
	@Test 
	public void testCountYearsBetween() {
		assertEquals(2, DateUtil.countYearsBetween(date1, date4));
		assertEquals(0, DateUtil.countYearsBetween(date1, date2));
	}
	
	@Test 
	public void testIsBetween() {
		assertTrue(DateUtil.isBetween(date2, date1, date3));
		assertFalse(DateUtil.isBetween(date1, date2, date3));
	}

}
