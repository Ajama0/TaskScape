package com.TaskScape.Controller;

import com.TaskScape.Dto.TaskRequestDto;
import com.TaskScape.Dto.TaskResponseDto;
import com.TaskScape.Service.TaskService;
import lombok.NonNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/Tasks")
public class TaskController {


    private final TaskService taskService;

    public TaskController(TaskService taskService){
        this.taskService = taskService;
    }

    @GetMapping(path="/tasks")
    public ResponseEntity<List<TaskResponseDto>> fetchAllTasks(){
        List<TaskResponseDto> tasks = taskService.fetchTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    @PostMapping ("/create")
    public ResponseEntity<TaskRequestDto> welcomeUsers(@NonNull @RequestBody TaskRequestDto task){
        TaskRequestDto taskCreated = taskService.createTasks(task);
        return new ResponseEntity<>(taskCreated, HttpStatus.CREATED);
    }
}
