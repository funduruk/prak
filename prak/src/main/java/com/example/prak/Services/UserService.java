package com.example.prak.Services;

import com.example.prak.Entities.Enums.Role;
import com.example.prak.Entities.Users;
import com.example.prak.Repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public boolean createUser(Users user){
        String email = user.getEmail();
        if (userRepository.findByEmail(email) != null) return false;
        user.setActive(true);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.getRoles().add(Role.ROLE_USER);
        log.info("saving new user with email: {}", email);
        userRepository.save(user);
        return true;

    }
    public Users getUserByPrincipal(Principal principal) {
        if (principal == null) return new Users();
        return userRepository.findByEmail(principal.getName());
    }




}
