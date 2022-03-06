package com.sealsugar.gymapp.security.controller;

import com.sealsugar.gymapp.security.entity.User;
import com.sealsugar.gymapp.security.repository.UserRepository;
import com.sealsugar.gymapp.security.service.JwtUserDetailsService;
import com.sealsugar.gymapp.security.util.JwtTokenUtil;
import lombok.AllArgsConstructor;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/auth")
@AllArgsConstructor
public class JwtAuthenticationController {

    protected final Log logger = LogFactory.getLog(getClass());

    final UserRepository userRepository;
    final AuthenticationManager authenticationManager;
    final JwtUserDetailsService userDetailsService;
    final JwtTokenUtil jwtTokenUtil;

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(
            @RequestParam("user_name") String username,
            @RequestParam("password") String password
    ) {
        Map<String, Object> responseMap = new HashMap<>();

        try {

            Authentication auth = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));

            if (auth.isAuthenticated()) {

                logger.info("Logged In");
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                String token = jwtTokenUtil.generateToken(userDetails);
                loginMapper(responseMap, "Logged In", token);
                return ResponseEntity.ok(responseMap);
            } else {
                errorMapper(responseMap,  "Invalid Credentials");
                return ResponseEntity.status(401).body(responseMap);
            }
        } catch (DisabledException e) {
            e.printStackTrace();
            errorMapper(responseMap,  "User is disabled");
            return ResponseEntity.status(500).body(responseMap);
        } catch (BadCredentialsException e) {
            errorMapper(responseMap,  "Invalid Credentials");
            return ResponseEntity.status(401).body(responseMap);
        } catch (Exception e) {
            e.printStackTrace();
            errorMapper(responseMap,  "Something went wrong");
            return ResponseEntity.status(500).body(responseMap);
        }
    }

    @PostMapping("/register")
    public ResponseEntity<?> saveUser(
            @RequestParam("first_name") String firstName,
            @RequestParam("last_name") String lastName,
            @RequestParam("user_name") String userName,
            @RequestParam("email") String email,
            @RequestParam("password") String password
    ) {
        Map<String, Object> responseMap = new HashMap<>();
        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setEmail(email);
        user.setPassword(new BCryptPasswordEncoder().encode(password));
        user.setRole("USER");
        user.setUserName(userName);
        userRepository.save(user);
        UserDetails userDetails = userDetailsService.loadUserByUsername(userName);
        String token = jwtTokenUtil.generateToken(userDetails);

        loginMapper(responseMap, "Account created successfully", token);
        responseMap.put("username", userName);

        return ResponseEntity.ok(responseMap);
    }

    private void loginMapper(Map<String, Object> responseMap, String message, String token) {
        responseMap.put("error", false);
        responseMap.put("message", message);
        responseMap.put("token", token);
    }

    private void errorMapper(Map<String, Object> responseMap, String message) {
        responseMap.put("error", true);
        responseMap.put("message", message);
    }
}