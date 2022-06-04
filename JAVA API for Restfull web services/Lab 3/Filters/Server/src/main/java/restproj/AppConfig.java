package restproj;

import jakarta.ws.rs.core.Application;
 
import java.util.HashSet;
import java.util.Set;

import jakarta.ws.rs.ApplicationPath;

@ApplicationPath("v1")
public class AppConfig extends Application {
    
    private Set<Class<?>> resources = new HashSet<>();
    public AppConfig ()
    {
        System.out.print("Created App Config");
        resources.add(Resource1.class);
    
        
    }

    @Override
    public Set<Class<?>> getClasses(){
        return resources;
    }

}
