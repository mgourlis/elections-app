package gr.ypes.electionsapp.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

@Component
@Path("/elections/resources/periphery")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PeripheryResource {

	@GET
    public String getPeripheries() {
		return "{\"periphery\":\"attiki\"}";
    }
	
}
