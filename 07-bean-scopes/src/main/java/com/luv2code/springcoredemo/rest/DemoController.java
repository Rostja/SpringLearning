package com.luv2code.springcoredemo.rest;

import com.luv2code.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    //define a private field for the dependency
    private Coach myCoach;
    private Coach anotherCouch;

@Autowired
public DemoController(@Qualifier("cricketCoach") Coach theCoach,
                      @Qualifier("cricketCoach") Coach theAnotherCouch){
        System.out.println("In constructor: " + getClass().getSimpleName());
        myCoach = theCoach;
        anotherCouch = theAnotherCouch;
}


    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return myCoach.getDailyWorkout();
    }
    @GetMapping("/check")
    public String check(){
    return "Comparing beans: myCoach == anotherCoach, " + (myCoach == anotherCouch);
    }
}
