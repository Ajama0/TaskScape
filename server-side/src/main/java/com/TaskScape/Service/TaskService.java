package com.TaskScape.Service;


import com.TaskScape.Constants.Status;
import com.TaskScape.Dto.TaskDTO;
import com.TaskScape.Exceptions.TaskException;
import com.TaskScape.Mapper.TaskMapper;
import com.TaskScape.Models.Task;
import com.TaskScape.Repository.TaskRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    @Transactional
    public TaskDTO createTasks(TaskDTO task) {
        //we can do some simple validations, to check if the task already exists(this is for a single user for now)
        List<Task> validateDuplicates = taskRepository.findByTitleAndDescription(
                task.getTitle(), task.getDescription()
        );

        //this means there are no duplicative tasks already for this user, (prevent an overload of the same task being persisted)
        if(!validateDuplicates.isEmpty()){
            throw new TaskException(task.getTitle() + "is already set to another task, please add a different title");

        }

        /**
         * For persistence to the database convert the Dto back into a task Object
         * Task retrieveTask = TaskMapper.DtoToEntityMapper(task);
         * set the current date automatically whenever a user creates a new task
         * retrieveTask.setCreatedDate(LocalDate.now());
         * we can return all tasks to the client based on their input of the due date
         * eg 7 days remaining -> calculate difference between due date and LocalDate.now()
         * set status to Pending automatically upon task creation by the user
         *
         */

        Task retrieveTask = TaskMapper.DtoToEntityMapper(task);
        retrieveTask.setCreatedDate(LocalDate.now());
        retrieveTask.setStatus(Status.PENDING);

        taskRepository.save(retrieveTask);

        //return DTO back to the user
        return new TaskDTO(retrieveTask);
    }
}
