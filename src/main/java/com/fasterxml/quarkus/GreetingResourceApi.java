package com.fasterxml.quarkus;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.ParameterIn;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

public interface GreetingResourceApi {
    @GET
    public String hello();

    @GET
    @Operation(summary = "Get a doc", description = "Get a document from data store")
    @APIResponses(
            value = {
                    @APIResponse(responseCode = "200", description = "OK",
                            content = @Content(
                                    schema = @Schema(implementation = String.class))),
                    @APIResponse(ref = Constants.Responses.GENERAL_400),
            })
    public Response getDocument(
            @Parameter(name = "raw", ref = Constants.Parameters.RAW)
            final boolean raw,
            @Parameter(in = ParameterIn.QUERY, name = "sort", description = "Keys to sort by")
            @QueryParam("sort")
            final String sort);
}
