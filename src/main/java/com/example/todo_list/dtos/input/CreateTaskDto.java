package com.example.todo_list.dtos.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateTaskDto(
        @NotBlank
        String title,

        @NotBlank
        String description,

        @NotNull
        Integer priority) {
}
