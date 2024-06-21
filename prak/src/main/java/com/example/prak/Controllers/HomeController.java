package com.example.prak.Controllers;

import com.example.prak.Services.ReadWordService;
import com.example.prak.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping("/")
    public String index(Model model, Principal principal) {
        model.addAttribute("user", userService.getUserByPrincipal(principal));
        return "index"; // возвращаем имя шаблона (без расширения .ftl)
    }
}