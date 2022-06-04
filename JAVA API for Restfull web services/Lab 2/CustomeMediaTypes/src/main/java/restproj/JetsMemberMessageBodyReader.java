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
@Consumes("jets/hashem")
public class JetsMemberMessageBodyReader implements MessageBodyReader<JetsMember> {

    @Override
    public boolean isReadable(Class<?> type, Type genericType, Annotation[] annotations, MediaType mediaType) {
        return JetsMember.class.isAssignableFrom(type);
    }

    @Override
    public JetsMember readFrom(Class<JetsMember> type, Type genericType, Annotation[] annotations, MediaType mediaType,
            MultivaluedMap<String, String> httpHeaders, InputStream entityStream)
            throws IOException, WebApplicationException {
                
                String jmStr = new String(entityStream.readAllBytes());
                jmStr = jmStr.trim();
                jmStr = jmStr.replace("JetsMember [name=", "");
                jmStr = jmStr.replace("]", "");
                return new JetsMember(jmStr);
    }
    
}
