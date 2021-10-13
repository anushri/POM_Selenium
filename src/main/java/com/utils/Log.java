package com.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Log {

    private static final Logger Log = LogManager.getLogger(Log.class.getName());

    // Initialize Log4j logs
    static {
        String log4jpath = System.getProperty("user.dir") + "/src/main/resources/log4j2.xml";
        System.setProperty("logoutputpath", System.getProperty("user.dir"));
        System.setProperty("log4j.configurationFile", log4jpath);
    }

    // This is to print log for the beginning of the test case, as we usually run so many test cases as a test suite

    public static void startTestCase(String sTestCaseName) {

        Log.info("****************************************************************************************");

        Log.info("------------------                " + sTestCaseName + "       ------------------------");

        Log.info("****************************************************************************************");

    }

    //This is to print log for the ending of the test case

    public static void endTestCase() {

        Log.info("------------------              " + "-E---N---D-" + "             ------------------ ");
    }

    // Log level methods

    public static void info(String message) {

        Log.info(message);

    }

    public static void warn(String message) {

        Log.warn(message);

    }

    public static void error(String message, Exception e) {

        Log.error(message, e);

    }

    public static void fatal(String message) {

        Log.fatal(message);

    }

    public static void debug(String message) {

        Log.debug(message);

    }


}
