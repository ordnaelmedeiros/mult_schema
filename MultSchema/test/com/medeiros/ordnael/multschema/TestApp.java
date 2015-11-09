package com.medeiros.ordnael.multschema;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.junit.Test;

import junit.framework.TestCase;

public class TestApp extends TestCase {

	private static Client client = null;
	
	public static Client getClient() {
		if (client==null) {
			client = ClientBuilder.newClient();
		}
		return client;
	}
	
	public static WebTarget getWebTarget(String path) {
		WebTarget target = getClient().target("http://localhost:8080/MultSchema/rest/"+path);
		return target;
	}
	
	@Test
	public void test() {
		assertTrue(true);
	}
	
}
