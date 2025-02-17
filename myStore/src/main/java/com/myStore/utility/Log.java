package com.myStore.utility;

import org.apache.log4j.Logger;

import com.myStore.base.BaseClass;

public class Log extends BaseClass {

	// Initialize Log4j logs
	public static Logger Log = Logger.getLogger(Log.class.getName());

	public static void startTestCase(String sTestCaseName) {
		Log.info("-------------------" + sTestCaseName + " Test start");
	}

	public static void endTestCase(String sTestCaseName) {
		Log.info("-------------------" + sTestCaseName + " Test end");
	}

	// Need to create below methods, so that they can be called

	public static void info(String message) {
		Log.info(message);
	}

	public static void warn(String message) {
		Log.warn(message);
	}

	public static void error(String message) {
		Log.error(message);
	}
    public static void fatal(String message) {
		Log.fatal(message);
	}

}
