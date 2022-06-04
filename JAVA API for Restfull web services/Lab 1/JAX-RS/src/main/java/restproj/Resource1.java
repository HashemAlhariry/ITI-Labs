package restproj;
 
import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import restproj.Exceptions.ResourceNotFoundException;
import restproj.entites.Department;
import restproj.entites.Employee;
import restproj.repositories.EmployeRepoIml;

@Path("resource1")
public class Resource1 {
    
    //check this
    private  EmployeRepoIml employeRepoIml = EmployeRepoIml.getInstance();
    
    @GET
    public List<Employee> getAllEmployees() {
        return EmployeRepoIml.employees;
    }

    @GET
    @Path("{id}")
    public Response getEmployee(@PathParam("id") int id) {

        Employee employee = employeRepoIml.getEmployeeWithId(id);
        if(employee == null){
            throw new ResourceNotFoundException("Order with ID:" + id + " Not Found");
        }
        return Response.ok().entity(employee).build();

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
