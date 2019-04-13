package au.org.consumerdatastandards.reference.api;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import au.org.consumerdatastandards.reference.impl.ProductApiServiceImpl;

import java.util.Set;
import java.util.HashSet;

@ApplicationPath("/")
public class RestApplication extends Application {


    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<Class<?>>();
        resources.add(ProductApiServiceImpl.class);

        return resources;
    }




}