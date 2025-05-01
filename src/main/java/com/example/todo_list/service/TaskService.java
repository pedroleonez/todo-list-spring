package com.example.todo_list.service;

import com.example.todo_list.dtos.input.CreateTaskDto;
import com.example.todo_list.dtos.input.UpdateTaskDto;
import com.example.todo_list.dtos.output.RecoveryTaskDto;
import com.example.todo_list.entity.Task;
import com.example.todo_list.mapper.TaskMapper;
import com.example.todo_list.repository.TaskRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository todoRepository;
    private final TaskMapper taskMapper;

    public TaskService(TaskRepository todoRepository, TaskMapper taskMapper) {
        this.todoRepository = todoRepository;
        this.taskMapper = taskMapper;
    }

    public void create(CreateTaskDto createTaskDto) {
        Task task = taskMapper.mapCreateTaskDtoToTask(createTaskDto);
        todoRepository.save(task);
    }

    public List<RecoveryTaskDto> list() {
        List<Task> tasks = todoRepository.findAll(Sort.by(Sort.Direction.ASC, "priority"));
        return tasks.stream()
                .map(taskMapper::mapTaskToRecoveryTaskDto)
                .toList();
    }

    public RecoveryTaskDto getById(Long id) {
        Task task = todoRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
        return taskMapper.mapTaskToRecoveryTaskDto(task);
    }

    public void update(Long taskId, UpdateTaskDto updateTaskDto) {
        Task task = todoRepository.findById(taskId).orElseThrow(() -> new RuntimeException("Task not found"));
        taskMapper.mapUpdateTaskDtoToTask(updateTaskDto, task);
        todoRepository.save(task);
    }

    public void delete(Long id) {
        todoRepository.deleteById(id);
    }
}
