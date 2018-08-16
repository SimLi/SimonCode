package com.devperson.conf;

import org.springframework.context.EnvironmentAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class SysEnvInvoke implements EnvironmentAware {
    /**
     * Set the {@code Environment} that this component runs in.
     *
     * @param environment
     */
    @Override
    public void setEnvironment(Environment environment) {
        System.out.println("加在环境变量");
        // environment.acceptsProfiles("system.dev=dev");
        System.out.println("system.dev == " + environment.getProperty("system.dev"));
        System.out.println(environment.getActiveProfiles());
    }
}
