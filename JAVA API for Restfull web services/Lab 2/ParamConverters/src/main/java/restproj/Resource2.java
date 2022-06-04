package restproj;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("resource2")
public class Resource2 {

    @GET
    @Path("{dateString}")
    @Produces(MediaType.TEXT_PLAIN)
        public String getEmployeeById(@PathParam("dateString") MyDate myDate) {
           return myDate.toString();
    }
}
