package gov.jets;

import gov.jets.controllers.MyClientRequestFilter;
import gov.jets.controllers.MyClientResponseFilter;
import gov.jets.controllers.RequestClientWriterInterceptor;
import gov.jets.controllers.ResponseClientReaderInterceptor;
import gov.jets.persistence.entity.Employee;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.MediaType;

public class Main {
    public static void main(String[] args) {
        
        Client client = ClientBuilder.newBuilder().
        register(MyClientRequestFilter.class).
        register(MyClientResponseFilter.class).
        register(ResponseClientReaderInterceptor.class).
        register(RequestClientWriterInterceptor.class).
        build();

        Employee user = client
            .target("http://localhost:9090/hateoas/api/resource1")
            .path("{id}")
            .resolveTemplate("id", "1")
            .request(MediaType.APPLICATION_JSON)
            .get(Employee.class);

        System.out.println(user);
    }
    
}
