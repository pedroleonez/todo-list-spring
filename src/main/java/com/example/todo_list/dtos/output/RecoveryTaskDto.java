package com.example.todo_list.dtos.output;

public record RecoveryTaskDto(
        Long id,
        String title,
        String description,
        boolean completed,
        int priority) {
}
