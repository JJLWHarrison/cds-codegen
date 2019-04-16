package au.org.consumerdatastandards.holder.api;

import au.org.consumerdatastandards.holder.impl.ProductApiServiceImpl;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/")
public class RestApplication extends Application {

    private Set<Object> singletons;
    private Set<Class<?>> classes;

    public RestApplication() {
        singletons = new HashSet<>();
        classes = new HashSet<>();
        classes.add(ProductApiServiceImpl.class);
        classes.add(io.swagger.jaxrs.listing.ApiListingResource.class);
        classes.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }

    @Override
    public Set<Class<?>> getClasses() {
        return classes;
    }
}