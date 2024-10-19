package com.luv2code.springcoredemo.common;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("cricketCoach")
public class CricketCouch implements Coach {

    public CricketCouch(){
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    //define our init and destroy method
    @PostConstruct
    public void doMyStuff(){
        System.out.println("In doMyStuff(): " + getClass().getSimpleName());
    }
    @PreDestroy
    public void clearMyStuff() {
        System.out.println("In clearMyStuff(): " + getClass().getSimpleName());
    }
    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes :-)";
    }
}
