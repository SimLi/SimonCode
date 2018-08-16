package com.devperson;

import com.devperson.listener.SimonApplicationEnvironmentPreparedEvent;
import com.devperson.listener.SimonApplicationStartingEvent;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SimonApplicationMain {

    public static void main(String[] args0) {
        SpringApplication springApplication = new SpringApplication(SimonApplicationMain.class);
//        springApplication.setAdditionalProfiles("spring.profiles.active="+System.getProperty("jasmp_env"));
//        springApplication.addListeners(new SimonApplicationStartingEvent());
        springApplication.addListeners(new SimonApplicationEnvironmentPreparedEvent());
        springApplication.run(args0);
        System.out.println("run运行完成");
    }
}
