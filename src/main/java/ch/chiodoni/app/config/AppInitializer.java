package ch.chiodoni.app.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.web.context.ConfigurableWebApplicationContext;

public class AppInitializer implements
        ApplicationContextInitializer<ConfigurableWebApplicationContext> {

    private final static Logger LOG = LoggerFactory.getLogger(AppInitializer.class);

    private static final String ENVIRONMENT = "ch.chiodoni.environment";
    private static final String CONTAINER = "ch.chiodoni.container";

    public void initialize(ConfigurableWebApplicationContext ctx) {
        String environment = System.getProperty(ENVIRONMENT);
        String container = System.getProperty(CONTAINER);
        ctx.getEnvironment().setActiveProfiles(environment,
                container);
        LOG.info("Application have been initialized. The following profiles have been activated: {}, {}", environment, container);
    }

}
