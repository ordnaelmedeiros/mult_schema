package com.medeiros.ordnael.multschema.resources.oauth;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.medeiros.ordnael.multschema.entitys.Logado;


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
	
	@POST
	@Path("login")
	public Logado login(String loginBase64) throws Exception {
		return this.getRes().login(loginBase64);
	}
	
}
