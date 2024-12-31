package com.TaskScape.Controller;

import com.TaskScape.Constants.Status;
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

    /**
     *
     * @return
     */
    @GetMapping(path="my-tasks")
    public ResponseEntity<List<TaskResponseDto>> fetchAllTasks(){
        List<TaskResponseDto> tasks = taskService.fetchTasks();
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    /**
     * best practice for a post request is to return only the Id back to the client
     * @param task
     * @return
     */
    @PostMapping ("/create")
    public ResponseEntity<Long> welcomeUsers(@NonNull @RequestBody TaskRequestDto task){
        Long taskId = taskService.createTasks(task);
        return new ResponseEntity<>(taskId,HttpStatus.CREATED);
    }

    /**
     *
     * @param taskId
     * @param status
     * @return
     */

    @PutMapping(path = "update/status")
    public ResponseEntity<TaskResponseDto> updateTaskStatus(@RequestParam("id")Long taskId,
                                                 @RequestParam ("value") Status status){

        TaskResponseDto updatedTask = taskService.updateTaskStatus(taskId, status);
        return new ResponseEntity<>(updatedTask, HttpStatus.OK);
    }

}
