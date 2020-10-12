package com.ondo.utils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class OndoDateUtil {

	public static List<Date> getLast48Hours() {
		List<Date> last48Hrs = new ArrayList<Date>();
		for (int i = 0; i <= 48; i++) {
			GregorianCalendar cal = new GregorianCalendar();// creates calendar
			cal.setTime(new Date()); // sets calendar time/date
			cal.add(GregorianCalendar.HOUR_OF_DAY, -i); // adds one hour
			cal.set(Calendar.MINUTE, 0);
			cal.set(Calendar.SECOND, 0);
			cal.set(Calendar.MILLISECOND, 0);
			cal.getTime();
			last48Hrs.add(cal.getTime());
				System.out.println(cal.getTime());
				System.out.println("--------------********************---------------");
		}
		return last48Hrs;
	}
}
