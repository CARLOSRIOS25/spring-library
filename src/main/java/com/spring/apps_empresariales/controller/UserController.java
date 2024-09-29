package com.spring.apps_empresariales.controller;

import com.spring.apps_empresariales.model.User;
import com.spring.apps_empresariales.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/usuarios")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/addUser")
    public String registrarUsuario(@RequestParam String nombre, @RequestParam Long num_celular,
                                   @RequestParam String username, @RequestParam String password) {
        User user = new User();
        user.setNombre(nombre);
        user.setNum_celular(num_celular);
        user.setUsername(username);
        user.setPassword(password);
        userRepository.save(user);
        return "redirect:/admin";
    }

    @GetMapping("/userlogin")
    public String user(){
        //nombre vista a retornar
        return "user";
    }

    @GetMapping("/all")
    public String obtenerUsuarios(Model model) {
        List<User> users = userRepository.findAll();
        //usamos stream para filtrar el usuario con id 1 y luego lo convertimos en una lista
        if (users != null) {
            users = users.stream().filter(user -> user.getId() != 1)
                    .collect(Collectors.toList());
        }
        model.addAttribute("users", users);
        return "listarUsuarios";
    }

    @DeleteMapping("/{id}")
    public void eliminarUsuario(@PathVariable Long id) {
        userRepository.deleteById(id);
    }

}
