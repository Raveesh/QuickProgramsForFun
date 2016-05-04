package com.stellapps;

import java.lang.management.ManagementFactory;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import com.stellapps.mbeans.Log4j;

public class Main {
	
	final static Logger logger = Logger.getLogger(Main.class);
	
	static{
		PropertyConfigurator.configure("/home/raveesh/Documents/stellapps-workspace2/logging-mbean/src/main/resources/log4j.properties");
	}
	public static void main(String[] args) throws MalformedObjectNameException, InstanceAlreadyExistsException, MBeanRegistrationException, NotCompliantMBeanException {
		
		MBeanServer mbs = ManagementFactory.getPlatformMBeanServer(); 
        ObjectName name = new ObjectName("com.stellapps.bean:type=Log4j"); 
        Log4j mbean = new Log4j(); 
        mbs.registerMBean(mbean, name); 
        
        while(true){
        	logger.error("This is an error message");
        	logger.info("This is a info message");
        	try {
				Thread.sleep(1000L);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

        }
        
        
	}

}
