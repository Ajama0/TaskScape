package com.TaskScape.TaskScape;


import com.TaskScape.TaskScape.Constants.Priority;
import com.TaskScape.TaskScape.Constants.Status;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;

@Configuration
public class TaskConfig {

    //inject Task repository

    private final TaskRepository taskRepository;

    public TaskConfig(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }
    /**
     * initial data to be added to serve the clients initial request
     *
     */
    @Bean
    CommandLineRunner commandLineRunner(){
        return args -> {
            //create an instance of the task and save some initial Tasks

            Task t1 = new Task(
                    "Complete 3K run",
                    "run a 3k as per the weekly schedule",
                    Priority.HIGH,
                    LocalDate.of(2025, Month.FEBRUARY, 12)
            );



            t1.setCreatedDate(LocalDate.of(2024, Month.DECEMBER, 30));
            t1.setStatus(Status.PENDING);

            taskRepository.save(t1);


        };

    }
}
