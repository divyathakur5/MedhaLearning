package com.ffg.medha.controller;


import com.ffg.medha.model.Student;
import com.ffg.medha.model.UserDetails;
import com.ffg.medha.service.UserServices;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;

@Data
@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    UserServices userServices;

    @PostMapping("googleSignIn")
    public String googleSignIn(){
        return "Success";
    }

    @PostMapping("/signIn")
    public String userSignIn(@RequestBody UserDetails userDetails)
            throws ExecutionException, InterruptedException {
        return userServices.signIn(userDetails);
    }
}
