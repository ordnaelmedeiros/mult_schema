package com.medeiros.ordnael.multschema;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@Startup
@Singleton
@ApplicationPath("rest")
public class App extends Application {
	
	
	@PostConstruct
	private void startup() {
		
	}
	
}