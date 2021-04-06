package com.example.demo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response {

    @Schema(description = "Unique identifier", example = "1")
    private final Long id;

    @Schema(description = "Student's name", example = "Andrey")
    private final String name;

    @Schema(description = "Student card unique number", example = "123")
    private final Integer studentCardNumber;

    @Schema(description = "Student's activity status", example = "true")
    private final Boolean active;
}
