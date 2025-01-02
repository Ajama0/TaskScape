package com.TaskScape.Exceptions;

public class InvalidTaskOperationException extends RuntimeException{

    public InvalidTaskOperationException(String message){
        super(message);
    }
}
