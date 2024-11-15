package dsa.examples.mocking;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;
import org.glassfish.jersey.server.ResourceConfig;

public class SwaggerApplication extends ResourceConfig {
    public SwaggerApplication() {
        packages("dsa.examples.mocking");

        // Register Swagger components
        register(ApiListingResource.class);
        register(SwaggerSerializers.class);

        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.0");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("localhost:8080");
        beanConfig.setBasePath("/api");
        beanConfig.setResourcePackage("dsa.examples.mocking");
        beanConfig.setPrettyPrint(true);
        beanConfig.setScan(true);
    }
}
