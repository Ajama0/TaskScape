package com.TaskScape.Service;


import com.TaskScape.Constants.Status;
import com.TaskScape.Dto.TaskRequestDto;
import com.TaskScape.Dto.TaskResponseDto;
import com.TaskScape.Exceptions.InvalidTaskOperationException;
import com.TaskScape.Exceptions.TaskNotFoundException;
import com.TaskScape.Mapper.TaskMapper;
import com.TaskScape.Models.Task;
import com.TaskScape.Repository.TaskRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository){
        this.taskRepository = taskRepository;
    }

    @Transactional
    public Long createTasks(TaskRequestDto task) {
        //we can do some simple validations, to check if the task already exists(this is for a single user for now)
        List<Task> validateDuplicates = taskRepository.findByTitleAndDescription(
                task.getTitle(), task.getDescription()
        );

        //this means there are no duplicative tasks already for this user, (prevent an overload of the same task being persisted)
        if(!validateDuplicates.isEmpty()){
            throw new TaskNotFoundException(task.getTitle() + "is already set to another task, please add a different title");

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

        return retrieveTask.getId();

    }

    public List<TaskResponseDto> fetchTasks() {
        List<Task> tasks = taskRepository.findAll();

        if(tasks.isEmpty()){
            throw new TaskNotFoundException("There are currently no available tasks");
        }
        //iterate through the tasks list and map each task to DTO, hide internals when sending back to client
        return tasks.stream()
                .filter(task -> task.getStatus()!=null)
                .map(task -> new TaskResponseDto(task))
                .collect(Collectors.toList());

    }

    public TaskResponseDto updateTaskStatus(Long taskId, Status status) {
        //validate the id to see if it exists
        //an error on this endpoint would redirect the user in the client-side to the task creation endpoint
        Task task = taskRepository.findById(taskId)
                .orElseThrow(()->new TaskNotFoundException("This task does not exist.. please create one"));

        //ensure the user is not setting the status to the same status
        if(task.getStatus().equals(status)){
            throw new TaskNotFoundException("please choose a different option");
        }
        task.setStatus(status);
        Task updatedTask = taskRepository.save(task);

        //map the task into a dto to return to the client side
        return new TaskResponseDto(updatedTask);
    }

    public TaskResponseDto updateToCompleted(Long taskId, Status status) {
        //ensure the task sent by the client holds a valid record
        Task retrieveTask = taskRepository.findById(taskId)
                .orElseThrow(()-> new TaskNotFoundException("Task with id: " + taskId + " does not exist"));

        if(retrieveTask.getStatus().equals(status)){
            throw new InvalidTaskOperationException("Status:" + status + " can not be persisted due to it holding the same value in the database");
        }

        //persist the status for the task of the client into the db
        retrieveTask.setStatus(status);

        Task task = taskRepository.save(retrieveTask);
        //return the dto to the client side allowing us to update the component
        return new TaskResponseDto(task);

    }

    public void deleteTasks(Long taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(()-> new TaskNotFoundException("Task with Id" + taskId + " not found"));

        taskRepository.delete(task);
    }

}
