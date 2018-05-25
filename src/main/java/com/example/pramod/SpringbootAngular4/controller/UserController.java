package com.example.pramod.SpringbootAngular4.controller;


import com.example.pramod.SpringbootAngular4.model.User;
import com.example.pramod.SpringbootAngular4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.awt.*;

@RestController
@RequestMapping(value = "/user",
                produces = MediaType.APPLICATION_JSON_VALUE,
                consumes = MediaType.APPLICATION_JSON_VALUE)
@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @Transactional(Transactional.TxType.REQUIRES_NEW)
    public void saveUser(@RequestBody User user){
        userRepository.save(user);
    }

    @RequestMapping(value ="/findall" ,method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @Transactional(Transactional.TxType.NEVER)
    public Iterable<User> getAllUser(){
        return userRepository.findAll();
    }

    @RequestMapping(value = "/findone/{id}",method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    @Transactional(Transactional.TxType.NEVER )
    public User getUser(@PathVariable("id") Long id){
        return userRepository.findOne(id);
    }

    @RequestMapping(value = "/delete/{id}",method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional(Transactional.TxType.NEVER)
    public void deleteUser(@PathVariable("id") Long id){
        userRepository.delete(id);
    }
}
