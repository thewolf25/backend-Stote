package org.ecommerce.security;

import org.ecommerce.dao.UserRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRespository userRespository;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

//        org.ecommerce.entities.User u = new org.ecommerce.entities.User();
//        u.setUsername(s);

//        User.UserBuilder user = User.withUsername("mehdi")
//                .password("mehdi")
//                .roles("User");


//        return user.build();
        return userRespository.findByUsername(s);
    }
}
