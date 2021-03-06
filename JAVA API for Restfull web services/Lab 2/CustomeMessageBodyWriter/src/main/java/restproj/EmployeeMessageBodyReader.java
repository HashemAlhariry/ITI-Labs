package restproj;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.ext.MessageBodyReader;
import jakarta.ws.rs.ext.Provider;

@Provider
@Consumes(MediaType.TEXT_PLAIN)
public class EmployeeMessageBodyReader implements MessageBodyReader<Employee> {

    @Override
    public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return Employee.class.isAssignableFrom(type);
    }

    @Override
    public Employee readFrom(Class<Employee> type, Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, String> httpHeaders, InputStream entityStream)
            throws IOException, WebApplicationException {
                String empStr = new String(entityStream.readAllBytes());
                System.out.println(empStr);
                empStr = empStr.trim();
                empStr = empStr.replace("Employee [", "");
                empStr = empStr.replace("]", "");
                String[] values = empStr.split(", ");
                int id = Integer.parseInt(values[0].replace("id=", ""));
                String name = values[1].replace("firstName=", "");
                int salary = Integer.parseInt(values[2].replace("salary=", ""));
                return new Employee(id, name, salary);
    }
    
}