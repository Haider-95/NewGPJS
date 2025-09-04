package se.systementor.supershoppen1.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PolicyController {

    @RequestMapping("/policy")
    public String showPolicy() {
        return "policy";
    }
}


