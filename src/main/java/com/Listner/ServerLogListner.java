package com.Listner;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ServerLogListner implements ServletContextListener {

	public void contextDestroyed(ServletContextEvent sc) {
		System.out.println("ServerShutDown....");
		//
	}

	public void contextInitialized(ServletContextEvent sc) {
		System.out.println("ServerStarted.....");
		//
	}
}
