package restproj;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;


@Path("members")
public class JetsMemberResource {

        @GET
        @Produces("jets/hashem")
        public JetsMember msgBodyWriter() {
            JetsMember jetsMember = new JetsMember("ETSHO");
            return jetsMember;
        }

        @POST
        @Consumes("jets/hashem")
        public void msgBodyReader(JetsMember jetsMember) {
                 System.out.println(jetsMember);
        }
        
}