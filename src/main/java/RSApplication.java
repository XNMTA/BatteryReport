package main.java;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class RSApplication extends Application<RSConfiguration> {
    public static void main(String[] args) throws Exception {
        new RSApplication().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<RSConfiguration> bootstrap) {

    }

    @Override
    public void run(RSConfiguration configuration, Environment environment) throws Exception {
        final RSResource RSResource = new RSResource(
                configuration.getTemplate()
        );
        environment.jersey().register(RSResource);
    }
}

