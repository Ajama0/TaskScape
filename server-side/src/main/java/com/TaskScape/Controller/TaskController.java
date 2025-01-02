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
     * @param taskId retrieved from the client side, to query the db associated to the task that made the request
     * @param status the value of the request param is binded to this method param and is the new value for the status
     * @return Response entity instance with return body as our DTO to hide internals and a 200 status code
     */

    @PutMapping(path = "update/status")
    public ResponseEntity<TaskResponseDto> updateToPendingStatus(@RequestParam("id")Long taskId,
                                                 @RequestParam ("value") Status status){

        TaskResponseDto updatedTask = taskService.updateTaskStatus(taskId, status);
        return new ResponseEntity<>(updatedTask, HttpStatus.OK);
    }

    @PutMapping(value="update/status/c")
    public ResponseEntity<TaskResponseDto>updateToCompletedStatus(
            //use a default value for the key of the request param
            @RequestParam("id") Long taskId,
            @RequestParam("id2") Status status
    ){
        TaskResponseDto taskToCompleted = taskService.updateToCompleted(taskId,status);
        return new ResponseEntity<>(taskToCompleted, HttpStatus.OK);
    }




}
