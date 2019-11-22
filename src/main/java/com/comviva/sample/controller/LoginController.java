package com.comviva.sample.controller;

import com.comviva.sample.entity.User;
import com.comviva.sample.model.UserModel;
import com.comviva.sample.repository.UserRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.xml.internal.ws.client.sei.ResponseBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * Created by arnab.goswami on 13-11-2019.
 */

@CrossOrigin
@RestController
public class LoginController {

    private User user;

    @Autowired
    UserRepository userRepository;


    @GetMapping(value="/login")
    public String loginPage(){
        return "Back to the login page";
    }


    @GetMapping(value="/success")
    public String successPage(){
        return "Authorisation Succesful";
    }

    @PostMapping(value = "/signup")
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


    @GetMapping(value ="/users/login")
    public ResponseEntity<?> validateUser(){
       // System.out.println(text);
        return ResponseEntity.ok().body("User is authorized in login");
    }


    @PostMapping(value ="/users/auth")
    public ResponseEntity<?> validateUser1(@RequestBody  String text){
        System.out.println(text);
        //return ResponseEntity.ok().header("Access-Control-Allow-Origin", "*").header("Access-Control-Allow-Methods","GET, OPTIONS, HEAD, PUT, POST").body("User is authorized");
        return ResponseEntity.ok().body("User is authorised in auth");
    }

    @GetMapping(value = "/")
    public String helloWorld(){
        return "<html><body><h1>Welcome to React_JAVA_App</h1></body></html>";
    }

}
