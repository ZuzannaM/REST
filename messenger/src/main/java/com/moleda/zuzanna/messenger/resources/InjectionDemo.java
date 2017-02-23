package com.moleda.zuzanna.messenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;


@Path("/injectiondemo")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
public class InjectionDemo {

	@GET
	public String getInjectionDemo(@MatrixParam("martixParam") String matrixParam,
									@HeaderParam("sessionID") String sId,
									@CookieParam("cookie") String cookie){
		return "MatrixParam : " + matrixParam + " sessionID: " + sId + " cookie: " + cookie;
	}
	
	@GET
	@Path("/context")
	public String getContext(@Context UriInfo uriInfo, @Context HttpHeaders headers){
		String path = uriInfo.getAbsolutePath().toString();
		String mediaType = headers.getAcceptableMediaTypes().toString();
		return "path: " + path + " mediaType: " + mediaType;
	}
}
