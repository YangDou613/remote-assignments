package com.example.assignment3;

import com.example.assignment3.entity.User;
import com.example.assignment3.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SpringBootApplication
@Controller
public class Assignment3Application implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;
    public static void main(String[] args) {
        SpringApplication.run(Assignment3Application.class, args);
    }

    @GetMapping("/homePage")
    public String home() {
        return "homePage";
    }

    @Override
    public void run(String... arg) {
//        User newUser = new User("testtest", "12345");
//        userRepository.save(newUser);
//        userRepository.findByEmail("testtest").forEach(
//                var -> System.out.println(var)
//        );
    }

    @PostMapping("/homePage")
    public ResponseEntity<String> check(@RequestParam String email,
                                        @RequestParam String password) {
        List<User> checkEmail = userRepository.findByEmail(email);
        if (checkEmail.isEmpty()) {
            User newUser = new User(email, password);
            userRepository.save(newUser);
            return ResponseEntity.status(200).build();
        } else {
            User user = checkEmail.get(0);
            if (user.getPassword().equals(password)) {
                return ResponseEntity.status(200).build();
            } else {
                return ResponseEntity.status(400).body("Please enter correct password.");
            }
        }
    }

    @GetMapping("/memberPage")
    public String memberPage() {
        return "memberPage";
    }
}
