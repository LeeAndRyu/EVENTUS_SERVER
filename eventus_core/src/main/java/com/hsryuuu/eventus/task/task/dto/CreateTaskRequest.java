package com.hsryuuu.eventus.task.task.dto;

import com.hsryuuu.eventus.task.task.type.TaskPriority;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateTaskRequest {
    private UUID parentId;
    private Integer seq;
    private String title;
    @Builder.Default
    private Boolean isCompleted = false;
    private UUID categoryId;
    @Builder.Default
    private TaskPriority priority = TaskPriority.LOW;
    private LocalDateTime startAt;
    private LocalDateTime dueAt;
}