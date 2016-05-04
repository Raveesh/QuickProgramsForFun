package com.stellapps.mbeans;

public interface Log4jMBean {
	
	public void setLoggingLevel(String loggerName,String logLevel);
	
	public String getLoggingLevel(String loggerName);
}
