package com.foody.be.auth.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.foody.be.auth.dto.LoginDto;
import com.foody.be.auth.dto.SignUpDto;
import com.foody.be.auth.model.Role;
import com.foody.be.auth.model.User;
import com.foody.be.auth.repository.RoleRepository;
import com.foody.be.auth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    private final ObjectMapper jsonMapper;

    public AuthController(ObjectMapper jsonMapper) {
        this.jsonMapper = jsonMapper;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/signin")
    public ResponseEntity<String> authenticateUser(@RequestBody LoginDto loginDto) throws JsonProcessingException {
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                loginDto.getUsername(), loginDto.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new ResponseEntity<>(this.jsonMapper.writeValueAsString(loginDto), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignUpDto signUpDto) throws JsonProcessingException {

        // add check for username exists in a DB
        if(userRepository.existsByUsername(signUpDto.getUsername())){
            return new ResponseEntity<>("Username is already taken!", HttpStatus.BAD_REQUEST);
        }

        // add check for email exists in DB
        if(userRepository.existsByEmail(signUpDto.getEmail())){
            return new ResponseEntity<>("Email is already taken!", HttpStatus.BAD_REQUEST);
        }

        // create user object
        User user = new User();
        user.setName(signUpDto.getName());
        user.setUsername(signUpDto.getUsername());
        user.setEmail(signUpDto.getEmail());
        user.setPassword(passwordEncoder.encode(signUpDto.getPassword()));

        Role roles = roleRepository.findByName("ROLE_ADMIN").get();
        user.setRoles(Collections.singleton(roles));

        userRepository.save(user);

        return new ResponseEntity<>(this.jsonMapper.writeValueAsString(signUpDto), HttpStatus.OK);

    }

    @GetMapping("/currentUser")
    public ResponseEntity<?> currentUser(@RequestBody String username) throws JsonProcessingException {

        Optional<User> currentUser = userRepository.findByUsername(username);

        return new ResponseEntity<>(this.jsonMapper.writeValueAsString(currentUser), HttpStatus.OK);

    }

    @GetMapping("/allUser")
    public ResponseEntity<?> allUser() throws JsonProcessingException {

        List<User> users = userRepository.findAll();

        return new ResponseEntity<>(this.jsonMapper.writeValueAsString(users), HttpStatus.OK);

    }


}
