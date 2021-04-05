package com.example.demo.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Response {

    private final Long id;
    private final String name;
    private final Integer studentCardNumber;
    private final Boolean active;
}
