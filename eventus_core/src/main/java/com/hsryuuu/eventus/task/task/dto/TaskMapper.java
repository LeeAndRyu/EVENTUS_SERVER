package com.hsryuuu.eventus.task.task.dto;

import com.hsryuuu.eventus.task.category.entity.Category;
import com.hsryuuu.eventus.task.task.entity.Task;

public class TaskMapper {

    public static Task toEntity(CreateTaskRequest req) {
        return Task.builder()
                .parentId(req.getParentId())
                .seq(req.getSeq())
                .title(req.getTitle())
                .isCompleted(false)
                .category(new Category(req.getCategoryId()))
                .startAt(req.getStartAt())
                .dueAt(req.getDueAt())
                .priority(req.getPriority())
                .build();
    }

    public static TaskDto fromEntity(Task task) {
        return TaskDto.builder()
                .id(task.getId())
                .parentId(task.getParentId())
                .seq(task.getSeq())
                .title(task.getTitle())
                .isCompleted(task.getIsCompleted())
                .categoryId(task.getCategory().getId())
                .priority(task.getPriority())
                .startAt(task.getStartAt())
                .dueAt(task.getDueAt())
                .createdAt(task.getCreatedAt())
                .updatedAt(task.getUpdatedAt())
                .creatorId(task.getCreatorId())
                .build();
    }

}
