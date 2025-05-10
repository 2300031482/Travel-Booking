package klu.controller;

import klu.model.User;
import klu.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    private final UserRepository userRepo;

    public AuthController(UserRepository repo) {
        this.userRepo = repo;
    }

    @PostMapping("/signup")
    public User signup(@RequestBody User user) {
        return userRepo.save(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        User found = userRepo.findByEmail(user.getEmail());
        if (found != null && found.getPassword().equals(user.getPassword())) {
            return "Login Successful!";
        }
        return "Invalid credentials!";
    }
}
