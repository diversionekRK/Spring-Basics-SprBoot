package com.div.spring.controllers;

import com.div.spring.dao.User;
import com.div.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Div on 2018-05-15.
 */
@Controller
public class AdminController {

    @Autowired
    private UserService userService;

    @RequestMapping("/admin")
    public String home(Model model) {
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);

        return "admin";
    }
}
