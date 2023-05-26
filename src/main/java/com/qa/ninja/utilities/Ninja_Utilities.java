package com.qa.ninja.utilities;

import java.util.Date;

public class Ninja_Utilities {
	
	public static String generateEmailDateTimeStamp() {
		Date date = new Date();
		String emailTimeStamp = date.toString().replace("", "_").replace(":", "_");
		return "chowdhurygs" + emailTimeStamp + "gmail.com";
	}
	public static CharSequence generatePasswordDateTimeStamp() {
		Date date1 = new Date();
		String passwordTimeStamp = date1.toString().replace("", "_").replace(":", "_");
		return "Shajlee" + passwordTimeStamp + "1234";
	}
	public static final int IMPLICIT_WAIT_TIME = 10;
	public static final int PAGELOAD_TIME = 10;
	public static final int SCRIPTLOAD_TIME = 10;
		
	
	}
	


