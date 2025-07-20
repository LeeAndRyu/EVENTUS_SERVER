package com.hsryuuu.eventus.task.task.dto;

import com.hsryuuu.eventus.task.task.type.TaskPriority;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TaskDto {
    private UUID id;
    private UUID parentId;
    private Integer seq;
    private String title;
    private Boolean isCompleted;
    private UUID categoryId;
    private TaskPriority priority;
    private LocalDateTime startAt;
    private LocalDateTime dueAt;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Map<String, Object> properties;
    private UUID creatorId;

}