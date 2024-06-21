package com.example.prak.Controllers;

import com.example.prak.Entities.Users;
import com.example.prak.Repositories.UserRepository;
import com.example.prak.Services.ReadWordService;
import com.example.prak.Services.UserService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;
import java.security.Principal;

@Controller
@RequiredArgsConstructor
public class WordController {

    @Autowired
    private final ReadWordService readWordService;
    @Autowired
    private final UserService userService;

    @GetMapping("/generate")
    public void generateWord (HttpServletResponse response, Principal principal, int id, Model model) throws IOException {
        try {
            model.addAttribute("user" ,userService.getUserByPrincipal(principal));
            readWordService.ReadDocument(response, principal, id);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
