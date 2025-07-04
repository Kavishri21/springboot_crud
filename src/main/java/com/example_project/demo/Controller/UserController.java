package com.example_project.demo.Controller;
import java.util.List;


import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


//import java.util.Optional;
//import java.util.Arrays;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;


//import org.springframework.web.bind.annotation.RequestParam;
//import com.example_project.demo.model.User;
import com.example_project.demo.repository.UserRepository;
import com.example_project.demo.Entity.userEntity;
import com.example_project.demo.exceptions.ResourceNotFoundException;



@RestController
@RequestMapping("/api/users") 

public class UserController {

    @Autowired
    private UserRepository userRepository;

    //@GetMapping()
    //public String getUsers() {
    //    return "Hello all!!";
    //}

    @GetMapping()
    public List<userEntity> getUsers() {
        // return Arrays.asList(new User(1L,"John","john@gmail.com"),
        // new User(2L,"Joe","joe@gmail.com"),
        // new User(3L,"Kavi","Kavi@gmail.com")
        // );
        return userRepository.findAll();
    }
    @PostMapping 
    public userEntity creatUser(@RequestBody userEntity user){
        //System.out.println("user data" + user.getName()+","+user.getEmail());
        return userRepository.save(user);
       // return null;   
  
    }
    @GetMapping("/{id}")  
    public userEntity gerUserById(@PathVariable Long id){  
        return userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with this id:  "+id));
    }

    @PutMapping("/{id}")
    public userEntity updateUser(@PathVariable Long id , @RequestBody userEntity user){
       userEntity userData = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with this id:  "+id));
        userData.setEmail(user.getEmail());
        userData.setName(user.getName());
        return userRepository.save(userData);
         
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id){
       userEntity userData = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User not found with this id:  "+id));
        userRepository.delete(userData);
        return ResponseEntity.ok().build();
    }

}