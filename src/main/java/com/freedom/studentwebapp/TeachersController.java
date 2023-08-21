package com.freedom.studentwebapp;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "http://localhost:8080/", method = RequestMethod.GET)
public class TeachersController {

    @RequestMapping(value = "http://localhost:8080/", method = RequestMethod.GET)
    public String main(){
        return "main";
    }
}
