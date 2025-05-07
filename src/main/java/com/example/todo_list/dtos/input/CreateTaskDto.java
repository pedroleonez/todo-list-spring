package com.example.todo_list.dtos.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;

public record CreateTaskDto(
        @NotBlank
        String title,

        @NotBlank
        String description,

        @NotNull
        @Min(1)
        @Max(3)
        Integer priority) {
}
