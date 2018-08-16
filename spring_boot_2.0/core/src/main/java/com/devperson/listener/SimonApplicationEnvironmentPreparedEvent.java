package com.devperson.listener;

import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.PropertySource;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SimonApplicationEnvironmentPreparedEvent implements
        ApplicationListener<ApplicationEnvironmentPreparedEvent> {
    /**
     * Handle an application event.
     *
     * @param event the event to respond to
     */
    @Override
    public void onApplicationEvent(ApplicationEnvironmentPreparedEvent event) {
        ConfigurableEnvironment envi = event.getEnvironment();
//        MutablePropertySources mps = envi.getPropertySources();
//        if (mps != null) {
//            Iterator<PropertySource<?>> iter = mps.iterator();
//            while (iter.hasNext()) {
//                PropertySource<?> ps = iter.next();
//                System.out.println("ps.getName:{};ps.getSource:{};ps.getClass:{}" + ps.getName() +"=="+   ps.getSource());
//            }
//        }
        envi.setActiveProfiles("dev");
        envi.setActiveProfiles("dev","dev");
//         envi.getPropertySources().addFirst( new MapPropertySource(""));
//        Map<String, Object> map = new HashMap<String, Object>();
//        map.put("spring.profiles.active", "dev");
//        MapPropertySource propertySource = new MapPropertySource("map", map);
//        envi.getPropertySources().addFirst(propertySource);
//        System.out.println("spring.profiles.active==" + envi.getActiveProfiles());
        envi.getProperty("spring.profiles.active");
        System.out.println(" == datasource.user " + envi.getProperty("spring.datasource.user"));
        // event.getEnvironment().addActiveProfile("");
    }
}
