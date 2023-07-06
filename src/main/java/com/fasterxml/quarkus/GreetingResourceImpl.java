package com.fasterxml.quarkus;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
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
