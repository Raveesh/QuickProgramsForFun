package com.stellapps.mbeans;

import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class Log4j implements Log4jMBean {

	public void setLoggingLevel(String loggerName, String logLevel) {
		System.out.println("Going to set log level");
		Properties props = new Properties();
		props.setProperty("log4j.category."+loggerName, logLevel);
		PropertyConfigurator.configure(props);
		System.out.println("i have no clue what the hell happened");

	}

	public String getLoggingLevel(String loggerName) {
		System.out.println("Going to return the loglevel for "+loggerName);
		return Logger.getLogger(loggerName).getLevel().toString();
	}

}
