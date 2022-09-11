package com.example.demo.userService.impl;

import com.example.demo.shared.Utils;
import com.example.demo.ui.model.request.UserDetailsRequestModel;
import com.example.demo.ui.model.response.UserRest;
import com.example.demo.userService.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class userServiceImpl implements UserService {
    Map<String, UserRest> users;
    Utils utils;

    public userServiceImpl() {}

    @Autowired
    public userServiceImpl(Utils utils){
        this.utils = utils;
    }

    @Override
    public UserRest createUser(UserDetailsRequestModel userDetails){

        UserRest returnValue = new UserRest();
        returnValue.setEmail(userDetails.getEmail());
        returnValue.setFirstName(userDetails.getFirstName());
        returnValue.setLastName(userDetails.getLastName());

        String userId = utils.generateUserId();
        returnValue.setUserId(userId);

        if(users == null)
        {
            users = new HashMap<>();

        }
        users.put(userId,returnValue);

        return returnValue;
    }
}
