package com.example.todo_list.service;

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

    public void create(Task task) {
        todoRepository.save(task);
    }

    public List<Task> list() {
        Sort sort = Sort.by("priority").descending().and(Sort.by("title").ascending());
        return todoRepository.findAll(sort);
    }

    public Task getById(Long id) {
        return todoRepository.findById(id).orElseThrow(() -> new RuntimeException("Task not found"));
    }

    public void update(Task task) {
        todoRepository.save(task);
    }

    public void delete(Long id) {
        todoRepository.deleteById(id);
    }
}
