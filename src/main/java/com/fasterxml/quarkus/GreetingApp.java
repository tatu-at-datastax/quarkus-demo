package com.fasterxml.quarkus;

import org.eclipse.microprofile.openapi.annotations.Components;
import org.eclipse.microprofile.openapi.annotations.OpenAPIDefinition;
import org.eclipse.microprofile.openapi.annotations.enums.ParameterIn;
import org.eclipse.microprofile.openapi.annotations.info.Info;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.ExampleObject;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.tags.Tag;

import javax.ws.rs.core.MediaType;

@OpenAPIDefinition(
        // note that info is defined via the properties
        info = @Info(title = "", version = ""),
        tags = { @Tag(name = "data", description = "DML operations") },
        components =
        @Components(
                // reusable parameters
                parameters = {
                        @Parameter(
                                in = ParameterIn.QUERY,
                                name = Constants.Parameters.RAW,
                                description = "Whether to 'unwrap' results object (omit wrapper)",
                                schema = @Schema(implementation = boolean.class)),
                },
                responses = {
                        @APIResponse(
                                name = Constants.Responses.GENERAL_400,
                                responseCode = "400",
                                description = "Bad request"
                        )
                }
        )
)
public class GreetingApp extends javax.ws.rs.core.Application {
}
