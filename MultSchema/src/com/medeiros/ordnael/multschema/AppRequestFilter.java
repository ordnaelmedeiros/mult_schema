package com.medeiros.ordnael.multschema;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class AppRequestFilter implements ContainerRequestFilter  {

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException {
		//requestContext.getMethod()
		//requestContext.getUriInfo().getPath()
		//requestContext.getUriInfo().get
		System.out.println("AppInterceptor");
		
	}

}
