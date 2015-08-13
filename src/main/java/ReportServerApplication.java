package main.java;

import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class ReportServerApplication extends Application<ReportServerConfiguration> {
    public static void main(String[] args) throws Exception {
        new ReportServerApplication().run(args);
    }

    @Override
    public String getName() {
        return "hello-world";
    }

    @Override
    public void initialize(Bootstrap<ReportServerConfiguration> bootstrap) {

    }

    @Override
    public void run(ReportServerConfiguration configuration, Environment environment) throws Exception {
        final ReportServerResource ReportServerResource = new ReportServerResource(
                configuration.getTemplate(),
                configuration.getDefaultName()
        );
        environment.jersey().register(ReportServerResource);
    }
}

