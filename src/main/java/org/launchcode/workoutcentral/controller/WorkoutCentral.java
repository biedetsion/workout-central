package org.launchcode.workoutcentral.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WorkoutCentral {

    @RequestMapping(value="workout")
    @ResponseBody
    public String index() {
        return "Hello World";

    }

}
