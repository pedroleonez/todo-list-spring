package com.example.todo_list.service;

import com.example.todo_list.dtos.input.CreateTaskDto;
import com.example.todo_list.dtos.input.UpdateTaskDto;
import com.example.todo_list.dtos.output.RecoveryTaskDto;
import com.example.todo_list.entity.Task;
import com.example.todo_list.repository.TaskRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

    private final TaskRepository todoRepository;

    public TaskService(TaskRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    public void create(CreateTaskDto createTaskDto) {
        Task task = new Task();
        task.setTitle(createTaskDto.title());
        task.setDescription(createTaskDto.description());
        task.setPriority(createTaskDto.priority());
        todoRepository.save(task);
    }

    public List<RecoveryTaskDto> list() {
        List<Task> tasks = todoRepository.findAll(Sort.by(Sort.Direction.ASC, "priority"));
        return tasks.stream()
                .map(task -> new RecoveryTaskDto(
                        task.getId(),
                        task.getTitle(),
                        task.getDescription(),
                        task.isCompleted(),
                        task.getPriority()))
                .toList();
    }

    public RecoveryTaskDto getById(Long id) {
        Task task = todoRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
        return new RecoveryTaskDto(
                task.getId(),
                task.getTitle(),
                task.getDescription(),
                task.isCompleted(),
                task.getPriority()
        );
    }

    public void update(Long taskId, UpdateTaskDto updateTaskDto) {
        Task task = todoRepository.findById(taskId).orElseThrow(() -> new RuntimeException("Task not found"));
        task.setTitle(updateTaskDto.title());
        task.setDescription(updateTaskDto.description());
        task.setCompleted(updateTaskDto.completed());
        task.setPriority(updateTaskDto.priority());
        todoRepository.save(task);
    }

    public void delete(Long id) {
        todoRepository.deleteById(id);
    }
}
