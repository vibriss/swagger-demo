package com.example.demo.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Request {

    @Schema(description = "Student's name", example = "Andrey", required = true)
    private final String name;

    @Schema(description = "Student card unique number", example = "123", required = true)
    private final Integer studentCardNumber;

    @Schema(description = "Student's activity status", example = "true", required = true)
    private final Boolean active;
}
