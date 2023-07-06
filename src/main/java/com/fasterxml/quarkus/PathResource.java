package com.fasterxml.quarkus;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.Encoded;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.PathSegment;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import java.util.List;

@ApplicationScoped
@Path("/path")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PathResource
{
    @GET
    @Path("/list/{primaryKey: .+}")
    public String pathAsList(@PathParam("primaryKey") List<PathSegment> path)
    {
        return "As List/std (%d) -> %s".formatted(path.size(), path);
    }

    @GET
    @Path("/listString/{primaryKey: .+}")
    public String pathAsStringList(@PathParam("primaryKey") List<String> path)
    {
        return "As List/String (%d) -> %s".formatted(path.size(), path);
    }

    @GET
    @Path("/listEncoded/{primaryKey: .+}")
    public String pathAsListEncoded(@Encoded @PathParam("primaryKey") List<String> path)
    {
        return "As List/encoded (%d) -> %s".formatted(path.size(), path);
    }

    @GET
    @Path("/string/{primaryKey: .+}")
    public String pathAsStringList(@PathParam("primaryKey") String path)
    {
        return "As String -> %s".formatted(path);
    }
}
