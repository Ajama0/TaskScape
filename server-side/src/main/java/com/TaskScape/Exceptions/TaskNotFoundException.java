package com.TaskScape.Exceptions;

public class TaskNotFoundException extends RuntimeException{

    public TaskNotFoundException(String message){
        super(message);
    }
}
