package com.medeiros.ordnael.multschema.controllers;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Response;

import org.junit.Test;

import com.medeiros.ordnael.multschema.TestApp;

import junit.framework.TestCase;

public class TestPingController extends TestCase {

	
	@Test
	public void testGet() {
		
		WebTarget target = TestApp.getWebTarget("ping");
		Response response = target.request().get();
        String value = response.readEntity(String.class);
        
        assertEquals("ping", value);
        
	}
	
}

