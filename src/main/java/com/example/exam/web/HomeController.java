package com.example.exam.web;

import com.example.exam.session.LoggedUserSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private final LoggedUserSession loggedUserSession;

    public HomeController(LoggedUserSession loggedUserSession) {
        this.loggedUserSession = loggedUserSession;
    }

    @GetMapping("/")
    public String index(){
        return "index";
    }
}
