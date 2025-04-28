package com.example.todo_list.dtos.input;

public record UpdateTaskDto(
        String title,
        String description,
        boolean completed,
        int priority) {
}
