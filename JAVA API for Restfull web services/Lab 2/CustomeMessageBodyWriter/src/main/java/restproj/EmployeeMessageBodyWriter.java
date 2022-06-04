package restproj;

import java.io.IOException;
import java.io.OutputStream;
import java.lang.annotation.Annotation;

import jakarta.ws.rs.Produces;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.MultivaluedMap;
import jakarta.ws.rs.ext.MessageBodyWriter;
import jakarta.ws.rs.ext.Provider;

@Provider
@Produces(MediaType.TEXT_PLAIN)
public class EmployeeMessageBodyWriter implements MessageBodyWriter<Employee> {

        @Override
        public boolean isWriteable(Class<?> type, java.lang.reflect.Type genericType, Annotation[] annotations, MediaType mediaType) {
                    return Employee.class.isAssignableFrom(type);
        }
        @Override
        public void writeTo(Employee employee, Class<?> type, java.lang.reflect.Type genericType, Annotation[] annotations, MediaType mediaType, MultivaluedMap<String, Object> httpHeaders, OutputStream entityStream) throws IOException, WebApplicationException {
                    entityStream.write(employee.toString().getBytes());
        }
}