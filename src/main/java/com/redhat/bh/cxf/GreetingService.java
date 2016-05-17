package com.redhat.bh.cxf;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path(value = "/")
public interface GreetingService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/greeting")
	String greeting(@QueryParam("name") String name);

}
