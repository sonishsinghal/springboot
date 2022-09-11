package com.example.demo.ui.controller;

import com.example.demo.exceptions.UserServiceException;
import com.example.demo.ui.model.request.UpdateUserDetailsRequestModel;
import com.example.demo.ui.model.request.UserDetailsRequestModel;
import com.example.demo.ui.model.response.UserRest;
import com.example.demo.userService.UserService;
import com.example.demo.userService.impl.userServiceImpl;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/users")  //https://localhost:8080/users

public class userController {

    Map<String, UserRest> users;

    @Autowired
    UserService userService;

//        @GetMapping(path="/{userId}", produces = {  MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}) // media type written in first will come by default
//    public ResponseEntity<UserRest> getUser(@PathVariable String userId){
//
//        UserRest returnValue = new UserRest();
//        returnValue.setEmail("sonishsinghal2gmail.com");
//        returnValue.setUserId("sonishsinghal");
//        returnValue.setFirstName("Sonish");
//        returnValue.setLastName("Singhal");
//        return new ResponseEntity<UserRest>(returnValue, HttpStatus.ACCEPTED);
//    }
//
//    @GetMapping
//    public String getUser(@RequestParam(value ="page", defaultValue = "1") int page, @RequestParam(value="limit", defaultValue = "50") int limit, @RequestParam(value="sort", required = false) String sort){
//
//        return "get user was called with page = " + page + " limit = " +limit + "sort =" + sort;
//    }

    @GetMapping(path = "/{userId}")

    public ResponseEntity<UserRest> getUser(@PathVariable String userId){
        if(users.containsKey(userId)){
            return new ResponseEntity<UserRest>(users.get(userId),HttpStatus.OK);
        }
        else{
            return new ResponseEntity<UserRest>(HttpStatus.NO_CONTENT);
        }
    }

    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserRest> createUser(@RequestBody UserDetailsRequestModel userDetails){

        UserRest returnValue = userService.createUser(userDetails);

        return new ResponseEntity<UserRest>(returnValue, HttpStatus.OK);
    }

    @PutMapping(path = "/{userId}", consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserRest> updateUsers(@PathVariable String userId, @RequestBody UpdateUserDetailsRequestModel userDetails){

//        if(true) throw new UserServiceException("A user service exception is thrown");
        if(!users.containsKey(userId)){
            return new ResponseEntity<UserRest>(HttpStatus.NO_CONTENT);
        }

        UserRest returnValue = users.get(userId);
        returnValue.setFirstName(userDetails.getFirstName());
        returnValue.setFirstName(userDetails.getLastName());

        users.put(userId,returnValue);

        return new ResponseEntity<UserRest>(returnValue,HttpStatus.ACCEPTED);
    }

    @DeleteMapping(path = "/{userId}",
            produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<UserRest> deleteUser(@PathVariable String userId){

        if(!users.containsKey(userId)){
            return new ResponseEntity<UserRest>(HttpStatus.NO_CONTENT);
        }

        UserRest storedUserDetails = users.get(userId);
        users.remove(userId);

        return new ResponseEntity<UserRest>(storedUserDetails, HttpStatus.OK);

    }
}
