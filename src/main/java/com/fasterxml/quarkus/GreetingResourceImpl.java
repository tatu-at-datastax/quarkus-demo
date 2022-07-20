package com.fasterxml.quarkus;

import javax.enterprise.context.ApplicationScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.eclipse.microprofile.openapi.annotations.enums.ParameterIn;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

@ApplicationScoped
@Path("/hello")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Tag(ref = "Xdata")
public class GreetingResourceImpl implements GreetingResourceApi
{
    @Override
    public String hello() {
        return "Hello RESTEasy";
    }

    @Override
    public Response getDocument(
        final boolean raw,
        final String sort)
    {
        return Response.ok().entity("Foo!").build();
    }
}
