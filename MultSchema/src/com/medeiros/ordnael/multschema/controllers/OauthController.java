package com.medeiros.ordnael.multschema.controllers;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.medeiros.ordnael.multschema.entitys.Operador;
import com.medeiros.ordnael.multschema.resources.oauth.OauthResources;


@Path("oauth")
@Produces(MediaType.APPLICATION_JSON)
public class OauthController {
	
	private OauthResources res = new OauthResources();
	
	public OauthResources getRes() {
		return res;
	}
	public void setRes(OauthResources res) {
		this.res = res;
	}
	
	@GET
	public Operador get() {
		return this.getRes().get();
	}
	
}
