package gov.jets.controllers;

import java.io.IOException;

import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.ext.Provider;
import jakarta.ws.rs.ext.ReaderInterceptor;
import jakarta.ws.rs.ext.ReaderInterceptorContext;

@Provider
public class ResponseClientReaderInterceptor implements ReaderInterceptor {

    @Override
    public Object aroundReadFrom(ReaderInterceptorContext context) 
      throws IOException, WebApplicationException {
        System.out.println("Client: Response Client Reader Interceptor");
        return context.proceed();
    }
}
