package restproj;
 
import java.util.ArrayList;
import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Link;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import restproj.entites.Department;
import restproj.entites.Employee;
import restproj.repositories.EmployeRepoIml;

@Path("resource1")
public class Resource1 {
    
    @Context
    UriInfo uriInfo;
    
    private  EmployeRepoIml employeRepoIml = EmployeRepoIml.getInstance();
    
    @GET
    public List<Employee> getAllEmployees() {
        return EmployeRepoIml.employees;
    }

    @GET
    @Path("{id}")
    public Response getEmployee(@PathParam("id") int id) {

        Employee employee = employeRepoIml.getEmployeeWithId(id);
      
        Link self = Link.fromUriBuilder(uriInfo.getAbsolutePathBuilder()).rel("self").build();
        Link others = Link.fromUri(uriInfo.getPath()).build();
        List<Link> links = new ArrayList<>();
        links.add(self);
        links.add(others);
        employee.setLinks(links);
        
        return Response.ok(employee).build();

    }

    @POST 
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void addEmployee(Employee Employee){
        employeRepoIml.addEmployee(Employee);
    }

    @PUT 
    @Path("{id}")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public void updateEmployee(@PathParam("id")int id, Employee Employee){
        employeRepoIml.updateEmployee(id, Employee);
    }

    @DELETE 
    @Path("{id}")
    public void deleteEmployee(@PathParam("id") int id){
        employeRepoIml.deleteEmployee(id);
    }   

    @DELETE
    public void deleteAllEmployees(){
        employeRepoIml.deleteAllEmployee();
    }   

    @GET
    @Path("{id}/department")
    public Department getEmployeeDepartment(@PathParam("id") int id) {
        return employeRepoIml.getEmployeeWithId(id).getDepartment();
    }
    
    // delete get   
    /*
    @GET
    public Employee getEmployeeWithParamter( @QueryParam("id") int id) {
           return employeRepoIml.getEmployeeWithId(id);
    }
    */

}
