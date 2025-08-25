package se.systementor.supershoppen1.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import se.systementor.supershoppen1.shop.model.UserAccount;

@Controller
public class LoginController {
    @RequestMapping("/login")
        public String showLogin() {
            return "login";
        }
    // //Check for Credentials
    // @PostMapping("/login")
    // public String login(@ModelAttribute(name="loginForm") UserAccount login, Model m) {
    //     String uname = login.getEmail();
    //     String pass = login.getPassword();
    // if(uname.equals("Admin") && pass.equals("Admin@123")) {
    //     m.addAttribute("email", uname);
    //     m.addAttribute("password", pass);
    //     return "welcome";
    // }
    // m.addAttribute("error", "Incorrect Username & Password");
    // return "login";
    
    // }
}