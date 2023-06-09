package br.com.hla11.util;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

public class DateUtil {
		
	public static Date addDays(final Date date, int days) {
	    Date newDate = new Date(date.getTime());

	    GregorianCalendar calendar = new GregorianCalendar();
	    calendar.setTime(newDate);
	    calendar.add(Calendar.DATE, days);
	    newDate.setTime(calendar.getTime().getTime());

	    return newDate;
	}
	
	public static Date removeDays(final Date date, int days) {
	    Date newDate = new Date(date.getTime());

	    GregorianCalendar calendar = new GregorianCalendar();
	    calendar.setTime(newDate);
	    calendar.add(Calendar.DATE, - days);
	    newDate.setTime(calendar.getTime().getTime());

	    return newDate;
	}
	
	public static long countDaysBetween(final Date startDate, final Date endDate) {
		long diffInMillies = Math.abs(endDate.getTime() - startDate.getTime());
	    long diff = TimeUnit.DAYS.convert(diffInMillies, TimeUnit.MILLISECONDS);
	    return diff;
	}
	
	public static int countYearsBetween(final Date startDate, final Date endDate) {
		Calendar a = new GregorianCalendar();
	    a.setTime(startDate);
	    
	    Calendar b = new GregorianCalendar();
	    b.setTime(endDate);
				
	    int diff = b.get(Calendar.YEAR) - a.get(Calendar.YEAR);
	    
	    if (a.get(Calendar.MONTH) > b.get(Calendar.MONTH) || 
	        (a.get(Calendar.MONTH) == b.get(Calendar.MONTH) && a.get(Calendar.DATE) > b.get(Calendar.DATE))) {
	        diff--;
	    }
	    
	    return diff;
	}
	
	public static boolean isBetween(final Date date, Date startDate, final Date endDDate){
	    return !(date.before(startDate) || date.after(endDDate));
	}

}
