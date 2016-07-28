package com.mugu.restws.messanger.resoureces;

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

@Path("/injectdemo")
@Produces(MediaType.TEXT_PLAIN)
@Consumes(MediaType.TEXT_PLAIN)
public class InjectDemoResource {

	@GET
	@Path("/anotations")
	public String getParamsUsingAnnotation(@MatrixParam("param") String matrixparam,
										   @HeaderParam("header1") String hearder1,
										   @CookieParam("name") String cookie1) {
		return "matrixparam: " + matrixparam + " header1: "+ hearder1 + " cookieName: " + cookie1;
	}
	
	@GET
	@Path("context")
	public String getParamsUsingContext(@Context UriInfo uriInfo,
										@Context HttpHeaders httpHeader){
		
		String path= uriInfo.getAbsolutePath().toString();
		String cookies = httpHeader.getCookies().toString();
		return path + "cookies: "+ cookies;
	}
}
