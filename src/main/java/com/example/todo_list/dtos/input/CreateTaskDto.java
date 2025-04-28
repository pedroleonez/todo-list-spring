package com.example.todo_list.dtos.input;

public record CreateTaskDto(
        String title,
        String description,
        int priority) {
}
