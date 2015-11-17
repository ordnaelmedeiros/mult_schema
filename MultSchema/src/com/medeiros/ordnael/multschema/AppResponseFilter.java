package com.medeiros.ordnael.multschema;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;


public class AppResponseFilter implements ContainerResponseFilter {

	@Override
	public void filter(ContainerRequestContext arg0, ContainerResponseContext arg1) throws IOException {
		System.out.println("-> AppResponseFilter");
	}

}