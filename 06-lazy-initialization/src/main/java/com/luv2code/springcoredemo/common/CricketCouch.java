package com.luv2code.springcoredemo.common;

import org.springframework.stereotype.Component;

@Component("cricketCoach")
public class CricketCouch implements Coach {

    public CricketCouch(){
        System.out.println("In constructor: " + getClass().getSimpleName());
    }

    @Override
    public String getDailyWorkout() {
        return "Practice fast bowling for 15 minutes :-)";
    }
}
