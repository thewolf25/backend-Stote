package org.ecommerce.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;

import javax.servlet.Filter;



import java.io.IOException;
import java.security.Key;
import java.sql.Date;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;

import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

@Component
public class AuthenticationFilter extends OncePerRequestFilter {
//    @Autowired
//    private AuthenticationManager authenticationManager;

//    @Override
//    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
//            throws AuthenticationException {
//        try {
//            Users applicationUser = new ObjectMapper().readValue(request.getInputStream(), Users.class);
//
//            return authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(applicationUser.getUsername(),
//                            applicationUser.getPassword(), applicationUser.getAuthorities())
//            );
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//
//    @Override
//    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
//                                            Authentication authResult) throws IOException, ServletException {
//        // TODO Auto-generated method stubauthResult
//        Date exp = new Date(System.currentTimeMillis() + EXPIRATION_TIME);
//        Key key = Keys.hmacShaKeyFor(KEY.getBytes());
//        Claims claims = Jwts.claims().setSubject(((User) authResult.getPrincipal()).getUsername());
//        String token = Jwts.builder().setClaims(claims).signWith(key, SignatureAlgorithm.HS512).setExpiration(exp).compact();
//        response.addHeader("token", token);
//
//    }
    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    MyUserDetailsService myUserDteailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        String token="";
        String username="";

        if(request.getHeader("Authorization") != null && request.getHeader("Authorization").startsWith("Bearer ")) {
            token = request.getHeader("Authorization").substring(7);
            username = jwtUtil.extractUsername(token);
            System.out.println(token);
        }

        if(username != "" && SecurityContextHolder.getContext().getAuthentication() == null ) {
            UserDetails userDetails = myUserDteailsService.loadUserByUsername(username);
            System.out.println("Valide Token : ");

            if(jwtUtil.validateToken(token, userDetails)) {
                UsernamePasswordAuthenticationToken usernameAuth = new UsernamePasswordAuthenticationToken(userDetails,null,userDetails.getAuthorities());
                usernameAuth.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernameAuth);
            }
        }
        filterChain.doFilter(request, response);
    }


}


