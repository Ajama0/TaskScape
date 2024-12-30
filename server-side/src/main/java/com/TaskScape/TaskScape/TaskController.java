package com.TaskScape.TaskScape;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/Tasks")
public class TaskController {


    private final TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @PostMapping ("/create")
    public ResponseEntity<TaskDTO> welcomeUsers(@RequestBody TaskDTO task){
        TaskDTO taskCreated = taskService.createTasks(task);
        return new ResponseEntity<>(taskCreated, HttpStatus.OK);
    }
}
