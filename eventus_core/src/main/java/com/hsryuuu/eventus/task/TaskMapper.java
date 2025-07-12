package com.hsryuuu.eventus.task;

import com.hsryuuu.eventus.task.dto.CreateTaskRequest;
import com.hsryuuu.eventus.task.dto.TaskDto;
import com.hsryuuu.eventus.task.entity.Task;

public class TaskMapper {

    public static Task toEntity(CreateTaskRequest req) {
        return Task.builder()
                .title(req.getTitle())
                .type(req.getType())
                .status(req.getStatus())
                .priority(req.getPriority())
                .startAt(req.getStartAt())
                .dueAt(req.getDueAt())
                .properties(req.getProperties())
                .build();
    }

    public static TaskDto fromEntity(Task task) {
        return TaskDto.builder()
                .id(task.getId())
                .title(task.getTitle())
                .type(task.getType())
                .status(task.getStatus())
                .priority(task.getPriority())
                .startAt(task.getStartAt())
                .dueAt(task.getDueAt())
                .createdAt(task.getCreatedAt())
                .updatedAt(task.getUpdatedAt())
                .properties(task.getProperties())
                .creatorId(task.getCreatorId())
                .build();
    }

}
