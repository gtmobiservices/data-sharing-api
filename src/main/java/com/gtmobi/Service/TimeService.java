package com.gtmobi.Service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class TimeService {

	public static final String dd_MMM_YYYY_HH_MMA = "d-MMM-yyyy h:mma";
	// public static final String dd_MM_YYYY_HH_MMA="dd-MM-yyyy hh:mma";
	public static final String YYYY_MM_DD_HH_MM_SS = "yyyy-MM-dd HH:mm:ss";
	public static final String YY_MM_DD_HH_MM_SS = "yy-MM-dd HH:mm:ss";
	public static final String YYYY_MM_DD = "yyyy-MM-dd";
	public static final String dd_MM_YYYY_HH_MMA = "dd-MM-yyyy HH:mm:ss";
	public static final String HH_MMA = "hh:mm:ss a";
	public static final String dd_MMM_YYYY_HH_MMA_T = "dd-MMM-yyyy hh:mma Z";
	public static final String dd_MMM_YYYY_HH_MM_SS = "dd-MMM-yyyy hh:mm:ss";
	public static final String dd_MM_YYYY_HH_MM_SS = "dd-MM-yyyy hh:mm:ss";
	public static final String MMMDD_YYYY_HH_MM_SSA = "MMM dd, yyyy hh:mm:ssa";
	public static final String dd_MM_YYYY_HH_MM_SSA = "dd-MM-yyyy hh:mm:ssa";
	public static final String dd_MMM_YYYY = "dd-MMM-yyyy";
	public static final String d_MMM_YYYY = "d-MMM-yyyy";
	public static final String MMMMMdd_YYYY = "MMMMM dd, yyyy";
	public static final String EEE_MMDDYYYY_HHMMSS_GMTZ = "EEE MMM dd yyyy HH:mm:ss 'GMT'Z";
	public static final String dd_MMM_YYYY_HH_MMA_GMTZ = "d-MMM-yyyy h:mma 'GMT'Z";
	public static final String EEE_MMMDD_HHMMSS_Z_YYYY = "EEE MMM dd HH:mm:ss Z yyyy";

	public Timestamp getUTCTime() throws ParseException {
		SimpleDateFormat dateFormatGmt = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss.S");
		dateFormatGmt.setTimeZone(TimeZone.getTimeZone("GMT"));

		// Local time zone
		SimpleDateFormat dateFormatLocal = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss.S");

		// Time in GMT
		return new Timestamp(dateFormatLocal.parse(dateFormatGmt.format(new Date())).getTime());
	}

	public static Timestamp getUTCTime(Timestamp time) throws ParseException {
		if (time != null) {
			SimpleDateFormat dateFormatGmt = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss.S");
			dateFormatGmt.setTimeZone(TimeZone.getTimeZone("UTC"));

			// Local time zone
			SimpleDateFormat dateFormatLocal = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss.S");

			// Time in GMT
			return new Timestamp(dateFormatLocal.parse(dateFormatGmt.format(time)).getTime());
		} else {
			return null;
		}
	}

	public static Timestamp getUTCTime2() throws ParseException {
		SimpleDateFormat dateFormatGmt = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss.S");
		dateFormatGmt.setTimeZone(TimeZone.getTimeZone("GMT"));

		// Local time zone
		SimpleDateFormat dateFormatLocal = new SimpleDateFormat("yyyy-MMM-dd HH:mm:ss.S");

		// Time in GMT
		return new Timestamp(dateFormatLocal.parse(dateFormatGmt.format(new Date())).getTime());
	}
	
	public String getCreationTimeForVendor(Timestamp time) {
		if (time != null) {
			final SimpleDateFormat sdf = new SimpleDateFormat(dd_MM_YYYY_HH_MMA);
			Calendar cal = Calendar.getInstance();
			cal.setTime(time);
			cal.add(Calendar.HOUR_OF_DAY, 5);
			cal.add(Calendar.MINUTE, 30);
			return sdf.format(cal.getTime());
		} else {
			return null;
		}
	}

}
