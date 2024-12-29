package com.TaskScape.TaskScape;


import com.TaskScape.TaskScape.Constants.Priority;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.Month;

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
    CommandLineRunner commandLineRunner(TaskRepository taskRepository){
        return args -> {
            //create an instance of the task and save some initial Tasks

            Task t1 = new Task(
                    "Complete 3K run",
                    "run a 3k as per the weekly schedule",
                    Priority.HIGH,
                    LocalDate.of(2025, Month.FEBRUARY, 12)
            );

            taskRepository.save(t1);

        };

    }
}
