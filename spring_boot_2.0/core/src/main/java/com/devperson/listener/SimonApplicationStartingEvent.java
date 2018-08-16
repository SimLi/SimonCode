package com.devperson.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;

public class SimonApplicationStartingEvent implements ApplicationListener<ApplicationStartingEvent> {
    private Logger logger = LoggerFactory.getLogger(SimonApplicationStartingEvent.class);
    /**
     * Handle an application event.
     *
     * @param event the event to respond to
     */
    @Override
    public void onApplicationEvent(ApplicationStartingEvent event) {
        System.out.println("SimonApplicationStartingEvent");
        logger.info("SimonApplicationStartingEvent");
        //event.getSpringApplication().setEnvironment();
    }
}
