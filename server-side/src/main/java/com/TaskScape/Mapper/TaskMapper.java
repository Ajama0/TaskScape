package com.TaskScape.Mapper;

import com.TaskScape.Dto.TaskDTO;
import com.TaskScape.Models.Task;

public class TaskMapper {

    public static Task DtoToEntityMapper(TaskDTO taskDTO){
        return new Task(
                taskDTO.getTitle(),
                taskDTO.getDescription(),
                taskDTO.getPriority(),
                taskDTO.getDate()
        );
    }
}
