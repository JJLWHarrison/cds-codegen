package au.org.consumerdatastandards.reference.api;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import au.org.consumerdatastandards.reference.impl.BankingApiServiceImpl;

import java.util.Set;
import java.util.HashSet;

@ApplicationPath("/")
public class RestApplication extends Application {


    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<Class<?>>();
        resources.add(BankingApiServiceImpl.class);

        return resources;
    }




}