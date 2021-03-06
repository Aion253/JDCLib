package net.aionstudios.jdc.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * A class providing services relating to AOS's date-time systems.
 * @author Winter Roberts
 */
public class DateTimeServices {
	
	private static SimpleDateFormat mysqlDateForm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	private static SimpleDateFormat httpDateForm = new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss z", Locale.US);
	private static Calendar c;
	
	/**
	 * Generates a DateTime that matches the current time, compatible with MYSQL databases.
	 * @return The MYSQL formatted date.
	 */
	public static String getMysqlCompatibleDateTime() {
		return mysqlDateForm.format(new Date());
	}
	
	public static String getServerTime() {
	    httpDateForm.setTimeZone(TimeZone.getTimeZone("GMT"));
	    return httpDateForm.format(new Date());
	}
	
	public static String getHttpTime(Date d) {
	    httpDateForm.setTimeZone(TimeZone.getTimeZone("GMT"));
	    return httpDateForm.format(d);
	}
	
	/**
	 * Gets the current datetime plus thirty minutes.
	 * @return The current time plus thirty minutes.
	 */
	public static String getThirtyAddedDT() {
		long millis = Calendar.getInstance().getTimeInMillis();
		return mysqlDateForm.format(new Date(millis+1800000));
	}
	
	/**
	 * Returns the time from now a provided number of seconds later.
	 * @param seconds A number of seconds to add to the current time.
	 * @return The string result of these additional seconds.
	 */
	public static String getSecondsAddedDT(long seconds) {
		long millis = Calendar.getInstance().getTimeInMillis();
		return mysqlDateForm.format(new Date(millis+(1000*seconds)));
	}
	
	/**
	 * Reads a MYSQL formatted datetime to a Java date.
	 * @param dateTime	A String representing the date and time in the form of yyyy-MM-dd HH:mm:ss..
	 * @return The given datetime string as a date object.
	 */
	public static Date getDateTimeFromString(String dateTime) {
		Date d = new Date();
		try {
			d = mysqlDateForm.parse(dateTime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return d;
	}
	
	/**
	 * @return A long unix timestamp.
	 */
	public static long getUnixTimestamp() {
		return new Date().getTime()/1000;
	}
	
	/**
	 * @return The current cron-functional minute.
	 */
	public static int getCronMinute() {
		c = Calendar.getInstance();
		return c.get(Calendar.MINUTE);
	}
	
	/**
	 * @return The current cron-functional hour.
	 */
	public static int getCronHour() {
		c = Calendar.getInstance();
		return c.get(Calendar.HOUR_OF_DAY)-1;
	}
	
	/**
	 * @return The current cron-functional day of the month.
	 */
	public static int getCronDayOfMonth() {
		c = Calendar.getInstance();
		return c.get(Calendar.DAY_OF_MONTH);
	}
	
	/**
	 * @return The current cron-functional month.
	 */
	public static int getCronMonth() {
		c = Calendar.getInstance();
		return c.get(Calendar.MONTH)+1;
	}
	
	/**
	 * @return The current cron-functional day of the week.
	 */
	public static int getCronDayOfWeek() {
		c = Calendar.getInstance();
		int i = c.get(Calendar.DAY_OF_WEEK)-1;
		return i<1 ? 7 : i;
	}
	
	/**
	 * @return The current cron-functional year.
	 */
	public static int getCronYear() {
		c = Calendar.getInstance();
		return c.get(Calendar.YEAR);
	}
	
	/**
	 * @return The current cron-functional time.
	 */
	public static String getCronNowString() {
		return getCronMinute()+" "+getCronHour()+" "+getCronDayOfMonth()+" "+getCronMonth()+" "+getCronDayOfWeek()+" "+getCronYear();
	}

}
