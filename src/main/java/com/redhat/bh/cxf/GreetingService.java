package com.redhat.bh.cxf;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path(value = "/")
public interface GreetingService {

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/greeting/{name}")
	String greeting(@PathParam("name") String name);

}
