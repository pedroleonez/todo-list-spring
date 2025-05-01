package com.example.todo_list.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import com.example.todo_list.dtos.input.CreateTaskDto;
import com.example.todo_list.dtos.input.UpdateTaskDto;
import com.example.todo_list.dtos.output.RecoveryTaskDto;
import com.example.todo_list.entity.Task;

@Mapper(componentModel = "spring")
public interface TaskMapper {

    RecoveryTaskDto mapTaskToRecoveryTaskDto(Task task);
    
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "completed", ignore = true)
    Task mapCreateTaskDtoToTask(CreateTaskDto createTaskDto);
    
    @Mapping(target = "id", ignore = true)
    void mapUpdateTaskDtoToTask(UpdateTaskDto updateTaskDto, @MappingTarget Task task);
}
