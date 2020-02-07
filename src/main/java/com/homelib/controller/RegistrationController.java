package com.homelib.controller;

import com.homelib.model.User;
import com.homelib.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RegistrationController {
    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String registration(Model model) {
        return "registration";
    }

    @PostMapping("/registration")
    public String addUser(User user,
                          Model model) {


        if (user.getPassword() != null &&
                (!user.getPassword().equals(user.getPassword2()))) {
            model.addAttribute("message","Passwords are different");
            return "registration";
        }

        if (StringUtils.isEmpty(user.getEmail())
                || StringUtils.isEmpty(user.getUsername())
                || StringUtils.isEmpty(user.getPassword())) {
            model.addAttribute("message","Fields cannot be empty");
            return "registration";
        }

        if (!userService.addUser(user)) {
            model.addAttribute("message","User exists!");
            return "registration";
        }



        return "redirect:/login";
    }
}
