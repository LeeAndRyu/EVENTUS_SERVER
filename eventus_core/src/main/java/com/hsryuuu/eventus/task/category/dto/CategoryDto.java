package com.hsryuuu.eventus.task.category.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@AllArgsConstructor
@Data
public class CategoryDto {
    private UUID id;
    private String name;
    private UUID creatorId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
