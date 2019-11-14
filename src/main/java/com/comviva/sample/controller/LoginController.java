package com.comviva.sample.controller;

import com.comviva.sample.entity.User;
import com.comviva.sample.model.UserModel;
import com.comviva.sample.repository.UserRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * Created by arnab.goswami on 13-11-2019.
 */
@RestController
public class LoginController {

    private User user;

    @Autowired
    UserRepository userRepository;

    @PostMapping(value = "/signup")
    @CrossOrigin(origins = "http://localhost:3000")
    public String saveUser(@RequestBody HashMap<String, String> studentMap){

        ObjectMapper objectMapper = new ObjectMapper();
        UserModel userModel = objectMapper.convertValue(studentMap, new TypeReference<UserModel>(){} );
        System.out.println("Recieved :" + studentMap.toString() );
        user = new User();
//      /  user.setUserId(4L);
        user.setEmail(userModel.getEmail());
        user.setFirstName(userModel.getFirstName());
        user.setLastName(userModel.getLastName());
        user.setPassword(userModel.getPassword());
        user.setPhone(userModel.getPhone());


        try {
            userRepository.save(user);
            return "200";
        }catch(Exception e){
            return "400";
        }

    }

    @GetMapping(value = "/")
    public String helloWorld(){
        return "<html><body><h1>Welcome to React_JAVA_App</h1></body></html>";
    }

}
