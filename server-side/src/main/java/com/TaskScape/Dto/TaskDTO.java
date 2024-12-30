package com.TaskScape.Dto;

import com.TaskScape.Constants.Priority;
import com.TaskScape.Models.Task;

import java.time.LocalDate;

public class TaskDTO {

    private String title;
    private String description;
    private Priority priority;
    private LocalDate date;


    //mapping the Entity to a DTO
    public TaskDTO(Task task){
      this.title = task.getTitle();
      this.description = task.getDescription();
      this.priority = task.getPriority();
      this.date = task.getDate();

    }


    //mapping the Dto to an Entity



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Priority getPriority() {
        return priority;
    }

    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
