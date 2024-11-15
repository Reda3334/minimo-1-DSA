package dsa.examples.mocking;

import org.glassfish.grizzly.http.server.HttpServer;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.grizzly2.httpserver.GrizzlyHttpServerFactory;
import io.swagger.jaxrs.config.BeanConfig;

import org.glassfish.grizzly.http.server.StaticHttpHandler;

import java.net.URI;

public class Main {
    public static final String BASE_URI = "http://localhost:8080/dsaApp/";

    public static void main(String[] args) {
        // Configure Swagger
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setTitle("My API");
        beanConfig.setVersion("1.0.0");
        beanConfig.setBasePath("/dsaApp");
        beanConfig.setResourcePackage("dsa.examples.mocking");
        beanConfig.setScan(true);

        // Create ResourceConfig and specify the package containing your resources
        final ResourceConfig rc = new ResourceConfig().packages("dsa.examples.mocking");

        // URI where the server will run
        URI uri = URI.create(BASE_URI);

        // Create the Grizzly HTTP server
        HttpServer server = GrizzlyHttpServerFactory.createHttpServer(uri, rc);

        // Configure Swagger UI handler to serve static files
        // aqui hay que poner el path del swagger en resources
        StaticHttpHandler swaggerHandler = new StaticHttpHandler("src/main/resources/swagger-ui");

        // Add Swagger UI handler to the server
        server.getServerConfiguration().addHttpHandler(swaggerHandler, "/swagger-ui");

        // Start the server
        try {
            server.start();

            Thread.currentThread().join(); // Keep the main thread alive
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
