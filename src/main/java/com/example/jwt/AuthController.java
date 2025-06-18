package com.example.jwt;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UserDto userDto) {
        // 예시: 아이디/비밀번호가 "user"/"password"일 때만 성공
        if ("user".equals(userDto.getUsername()) && "password".equals(userDto.getPassword())) {
            String token = JwtUtil.generateToken(userDto.getUsername());
            return ResponseEntity.ok(new TokenResponse(token));
        }
        return ResponseEntity.status(401).body("Invalid credentials");
    }

    @GetMapping("/hello")
    public ResponseEntity<?> hello(@RequestHeader("Authorization") String authHeader) {
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7);
            if (JwtUtil.validateToken(token)) {
                String username = JwtUtil.getUsername(token);
                return ResponseEntity.ok("Hello, " + username + "!");
            }
        }
        return ResponseEntity.status(401).body("Invalid or missing token");
    }
}

class UserDto {
    private String username;
    private String password;
    // getters/setters
    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getPassword() { return password; }
    public void setPassword(String password) { this.password = password; }
}

class TokenResponse {
    private String token;
    public TokenResponse(String token) { this.token = token; }
    public String getToken() { return token; }
} 