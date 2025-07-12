package com.hsryuuu.eventus.task.dto;

import com.hsryuuu.eventus.task.type.TaskPriority;
import com.hsryuuu.eventus.task.type.TaskStatus;
import com.hsryuuu.eventus.task.type.TaskType;
import lombok.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateTaskRequest {
    private String title;
    private TaskType type;
    private TaskStatus status;
    private TaskPriority priority;
    private LocalDateTime startAt;
    private LocalDateTime dueAt;
    @Builder.Default
    private Map<String, Object> properties = new HashMap<>();
    private UUID creatorId;
}