package com.TaskScape.TaskScape;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/Tasks")
public class TaskController {


    @GetMapping("welcome")
    public ResponseEntity<String> welcomeUsers(){
        return new ResponseEntity<>("hello", HttpStatus.OK);
    }
}
