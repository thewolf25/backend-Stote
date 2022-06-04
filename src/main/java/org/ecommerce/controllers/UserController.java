package org.ecommerce.controllers;


import org.ecommerce.dao.RoleRepository;
import org.ecommerce.dao.UserRespository;
import org.ecommerce.entities.Role;
import org.ecommerce.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRespository userRepository;

    @Autowired
    RoleRepository roleRepository;

    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody User user ) {


        List<Role> roles = new ArrayList<Role>();
        roles.add(roleRepository.findById(1).get());
        user.setRoles(roles);
        System.out.println(user.getRoles().get(0).getNom());
        User u = userRepository.save(user);
        user.getRoles().stream().forEach((role) -> {
                    Role roledb = roleRepository.findById(role.getId()).get();
                    roledb.getUsers().add(u);
                    roleRepository.save(roledb);
                }
        );



    return new ResponseEntity<String>("Add With Success", HttpStatus.OK);

    }

    @GetMapping("/getAll")
    public List<User> getAllUser(){
        List<User> users = userRepository.findAll();
        return users;
    }


    @ExceptionHandler
    public ResponseEntity<String> handleExecpetion(Exception e){
        return new ResponseEntity<String>(e.getMessage(),HttpStatus.NOT_FOUND);
    }
    
    
    @PostMapping("/role/add")
    public ResponseEntity<String> addUser(@RequestBody Role role ) {
        roleRepository.save(role);
        return new ResponseEntity<String>("Add With Success", HttpStatus.OK);
    }
    
}
