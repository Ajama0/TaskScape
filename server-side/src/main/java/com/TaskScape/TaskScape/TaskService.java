package com.TaskScape.TaskScape;


import org.springframework.stereotype.Service;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }
    public TaskDTO createTasks(TaskDTO task) {
        //we can do some simple validations


    }
}
