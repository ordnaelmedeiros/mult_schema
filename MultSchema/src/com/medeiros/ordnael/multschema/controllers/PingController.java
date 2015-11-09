package com.medeiros.ordnael.multschema.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("ping")
public class PingController {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String get() {
		return "teste";
	}
	
}
