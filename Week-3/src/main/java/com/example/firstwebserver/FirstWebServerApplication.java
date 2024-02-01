package com.example.firstwebserver;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class FirstWebServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FirstWebServerApplication.class, args);
    }

    @GetMapping
    public String Hello() {
        return "Hello, My Server!";
    }

    @RequestMapping("/data")
    public String equations(@RequestParam(name = "number", required = false) String number) {
        try {
            if (number == null) {
                return "Lack of Parameter";
            } else {
                int intNumber = Integer.parseInt(number);
                if (intNumber == 1) {
                    return "Result: 1";
                } else {
                    String equation = "";
                    int answer = 0;
                    for (int i = 1; i <= intNumber; i++) {
                        if (equation.isEmpty()) {
                            equation = equation.concat(Integer.toString(i));
                        } else {
                            equation = (equation + "+").concat(Integer.toString(i));
                        }
                        answer += i;
                    }
                    return "Result: " + equation + "=" + answer;
                }
            }
        } catch(NumberFormatException e) {
            return "Wrong Parameter";
        }
    }

    @GetMapping("/myName")
    public ResponseEntity<String> checkName(@CookieValue(value = "username", defaultValue = "") String username) {
        if (!username.isEmpty()) {
            return ResponseEntity.ok("Username: " + username);
        } else {
            return ResponseEntity.ok(
                "<script>" +
                    "window.location.replace('http://localhost:3000/trackName')" +
                "</script>");
        }
    }

    @GetMapping("/trackName")
    public String trackName() {
        return
            "<form action='/trackName' method='post' onsubmit='encodeInput()'>" +
                "<label for='name'>Enter username:</label><br>" +
                "<input id='input' type='text' name='name'><br>" +
                "<button type='submit'>Submit</button>" +
            "</form>" +
            "<script>" +
            "function encodeInput() {" +
            "   var nameInput = document.getElementById('input');" +
            "   nameInput.value = encodeURIComponent(nameInput.value);" +
            "}" +
            "</script>";
    }

    @PostMapping("/trackName")
    public ResponseEntity<String> addName(@RequestParam("name") String name, HttpServletResponse response) {
        if (!name.isEmpty()) {
            Cookie cookie = new Cookie("username", name);
            response.addCookie(cookie);
        }
        return ResponseEntity.status(302).header("Location", "/myName").build();
    }

}
