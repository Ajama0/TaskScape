package com.TaskScape.Mapper;

import com.TaskScape.Dto.TaskRequestDto;
import com.TaskScape.Models.Task;

public class TaskMapper {

    public static Task DtoToEntityMapper(TaskRequestDto taskRequestDTO){
        return new Task(
                taskRequestDTO.getTitle(),
                taskRequestDTO.getDescription(),
                taskRequestDTO.getPriority(),
                taskRequestDTO.getDate()
        );
    }
}
