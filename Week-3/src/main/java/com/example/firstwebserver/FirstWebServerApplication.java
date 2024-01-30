package com.example.firstwebserver;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.http.ResponseCookie;
import org.springframework.http.ResponseEntity;

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
                    return "1";
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
                    return equation+"="+answer;
                }
            }
        } catch(NumberFormatException e) {
            return "Wrong Parameter";
        }
    }

    @GetMapping("/myName")
    public ResponseEntity<String> getMyName(@CookieValue(value = "username", defaultValue = "") String username) {
        if (!username.isEmpty()) {
            return ResponseEntity.ok("Username: " + username);
        } else {
            String form = String.format(
                "<form action=\"/trackName\" method=\"post\">" +
                "<label for=\"name\">Enter your name:</label><br>" +
                "<input type=\"text\" id=\"name\" name=\"name\"><br>" +
                "<button type=\"submit\">Submit</button>" +
                "</form>",
                "http://localhost:3000/trackName?name=使用者的輸入");

            return ResponseEntity.ok(form);

//            return ResponseEntity.ok(
//                "<form action=\"/trackName\" method=\"post\">" +
//                "  <label for=\"name\">Enter your name:</label><br>" +
//                "  <input type=\"text\" id=\"name\" name=\"name\"><br>" +
//                "  <button type=\"submit\">Submit</button>" +
//                "</form>");
        }
    }

    @PostMapping("/trackName")
    public ResponseEntity<String> trackName(@RequestParam("name") String name, HttpServletResponse response) {
        Cookie cookie = new Cookie("username", name);
        response.addCookie(cookie);
        return ResponseEntity.status(302).header("Location", "/myName").body(null);
    }
}
