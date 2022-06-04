package restproj;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@Path("employees")
public class EmployeeResource {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public Employee needsMsgBodyWriter() {
        Employee employee = new Employee(123, "amin", 10);
        return employee;
    } 

    
    @POST
    @Consumes(MediaType.TEXT_PLAIN)
    public void needsMsgBodyReader(Employee employee) {
        System.out.println(employee);
    }
}