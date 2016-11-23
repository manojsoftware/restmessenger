package org.manojit.messenger.resource;

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

@Path("/displayparam")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class AnnotationsDemo {
	@GET
	@Path("/annotations")
	public String displayAnnotaitonValue(@MatrixParam("param") String val,
			@HeaderParam ("CustomHeaderParam") String val2,
			@CookieParam("cookiename") String val3){
		
		return "Matrix value is :"+val+" HeaderParam value is :"+val2+" Cookie param is :"+val3;
	}
	@GET
	@Path("/context")
	public String displayParam(@Context UriInfo uriInfo, @Context HttpHeaders headers ){
		return "UriInfo"+uriInfo.getAbsolutePath().toString()+"Http Headers"+headers.getCookies().toString();
	}

}
