package com.example.todo_list.dtos.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UpdateTaskDto(
        @NotBlank
        String title,

        @NotBlank
        String description,

        boolean completed,

        @NotNull
        Integer priority) {
}
