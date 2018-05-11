package com.div.spring.controllers;

import com.div.spring.SpringbootApplication;
import com.div.spring.dao.User;
import com.div.spring.service.UserService;
import com.div.spring.validation.FormValidationGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by Div on 2018-05-11.
 */
@Controller
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(SpringbootApplication.class);

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model, String error, String logout) {

        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @RequestMapping(value = "/newaccount")
    public String createUser(Model model) {

        model.addAttribute("user", new User());
        return "newaccount";
    }

    @RequestMapping(value = "/createaccount", method = RequestMethod.POST)
    public String doCreate(@Validated(FormValidationGroup.class) User user, BindingResult result) {

        if(result.hasErrors()) {
            return "newaccount";
        }

        if(userService.exists(user.getUsername())) {
            result.rejectValue("username", "DuplicateKey.user.username");
            return "newaccount";
        }

        userService.save(user);
        return "accountcreated";
    }
}
