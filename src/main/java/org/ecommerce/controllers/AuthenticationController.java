package org.ecommerce.controllers;

import lombok.AllArgsConstructor;
import org.ecommerce.security.JwtUtil;
import org.ecommerce.security.RequestJWT;
import org.ecommerce.security.ResponseJWT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@AllArgsConstructor
public class AuthenticationController {

    private AuthenticationManager authenticationManager;

    private UserDetailsService userService;

    private JwtUtil jwtUtil;

    @PostMapping("/authenticate")
    public ResponseEntity<ResponseJWT> authenticate(@RequestBody RequestJWT request) throws Exception {
        final String token;
        UserDetails user;
        try{
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(),request.getPassword()));
       }
       catch(Exception e){
            throw new BadCredentialsException(e.getMessage());
        }
        user = userService.loadUserByUsername(request.getUsername());
        token = jwtUtil.generateToken(user);

        return new ResponseEntity<ResponseJWT>(new ResponseJWT(token), HttpStatus.OK);

    }


    @ExceptionHandler(BadCredentialsException.class)
    public ResponseEntity<String> handleException(Exception e){
        return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }




}
