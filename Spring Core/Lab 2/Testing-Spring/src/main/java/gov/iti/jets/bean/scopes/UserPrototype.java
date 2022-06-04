package gov.iti.jets.bean.scopes;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class UserPrototype implements InitializingBean , DisposableBean {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("USER PROTO TYPE initialization");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("USER PROTO TYPE Destroy");
    }
}
