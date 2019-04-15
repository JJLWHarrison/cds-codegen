package au.org.consumerdatastandards.holder.api;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

import au.org.consumerdatastandards.holder.DB;
import au.org.consumerdatastandards.holder.impl.ProductApiServiceImpl;

import java.util.Set;
import java.util.HashSet;

@ApplicationPath("/")
public class RestApplication extends Application {

    private Set<Object> singletons = new HashSet<Object>();

    public RestApplication() {
        try {
            singletons.add(new ProductApiServiceImpl());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Set<Object> getSingletons() {
        return singletons;
    }

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new HashSet<Class<?>>();
        resources.add(ProductApiServiceImpl.class);
        resources.add(io.swagger.jaxrs.listing.ApiListingResource.class);
        resources.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);
        return resources;
    }

}