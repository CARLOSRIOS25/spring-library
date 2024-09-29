package com.spring.apps_empresariales.controller;

import com.spring.apps_empresariales.model.User;
import com.spring.apps_empresariales.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/login")
    public String showLoginForm(){
        //nombre vista a retornar
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model) {
        User user = userService.authenticateUser(username, password);

        if (user != null){
            if (user.getId() == 1){
                return "redirect:/admin";
            } else {
                return "redirect:/usuarios/userlogin";
            }

        } else {
            model.addAttribute("error", "Usuario o contraseña incorrectos");
            return "login";
        }
    }

}
