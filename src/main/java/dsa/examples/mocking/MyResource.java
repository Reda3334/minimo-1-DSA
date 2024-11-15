package dsa.examples.mocking;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api(value = "My Resource", description = "This resource demonstrates Swagger documentation")
@Path("/myresource")
public class MyResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @ApiOperation(value = "Get a message", notes = "This is a simple GET endpoint that returns a message")
    public String getIt() {
        return "Got it!";
    }

    @GET
    @Path("/newEndpoint")
    @Produces(MediaType.TEXT_PLAIN)
    @ApiOperation(value = "Get a new message", notes = "This is a new GET endpoint that returns a different message")
    public String newEndpoint() {
        return "This is a new endpoint!";
    }
}
