package com.example.todo_list.controller;

import com.example.todo_list.dtos.input.CreateTaskDto;
import com.example.todo_list.dtos.input.UpdateTaskDto;
import com.example.todo_list.dtos.output.RecoveryTaskDto;
import com.example.todo_list.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid CreateTaskDto createTaskDto) {
        taskService.create(createTaskDto);
        return ResponseEntity.status(201).build();
    }

    @GetMapping
    public ResponseEntity<List<RecoveryTaskDto>> list() {
        List<RecoveryTaskDto> tasks = taskService.list();
        return ResponseEntity.ok(tasks);
    }

    @GetMapping("{id}")
    public ResponseEntity<RecoveryTaskDto> getById(@PathVariable("id") Long id) {
        RecoveryTaskDto task = taskService.getById(id);
        return ResponseEntity.ok(task);
    }

    @PutMapping("{id}")
    public ResponseEntity<Void> update(@PathVariable("id") Long id, @RequestBody @Valid UpdateTaskDto updateTaskDto) {
        taskService.update(id, updateTaskDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") Long id) {
        taskService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
