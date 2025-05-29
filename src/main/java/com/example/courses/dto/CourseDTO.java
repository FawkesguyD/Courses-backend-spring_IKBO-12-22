package com.example.courses.dto;

import lombok.Data;
import java.math.BigDecimal;

@Data
public class CourseDTO {
    private Long id;
    private String title;
    private String description;
    private String instructor;
    private Integer durationHours;
    private BigDecimal price;
} 