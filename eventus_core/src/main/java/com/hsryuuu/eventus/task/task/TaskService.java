package com.hsryuuu.eventus.task.task;

import com.hsryuuu.eventus.appllication.exception.ErrorCode;
import com.hsryuuu.eventus.appllication.exception.impl.TaskException;
import com.hsryuuu.eventus.task.task.dto.CreateTaskRequest;
import com.hsryuuu.eventus.task.task.dto.TaskDto;
import com.hsryuuu.eventus.task.task.dto.TaskMapper;
import com.hsryuuu.eventus.task.task.entity.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskDto createTask(CreateTaskRequest req) {
        this.validateParentExists(req.getParentId());
        Task entity = TaskMapper.toEntity(req);
        Task saved = taskRepository.save(entity);
        return TaskMapper.fromEntity(saved);
    }

    private void validateParentExists(UUID parentId) {
        if (parentId != null && !taskRepository.existsById(parentId)) {
            throw new TaskException(ErrorCode.TASK_PARENT_DOESNT_EXISTS);
        }
    }

    public List<TaskDto> getAllTasks(UUID userId) {
        return taskRepository.findByCreatorId(userId)
                .stream()
                .map(TaskMapper::fromEntity)
                .toList();
    }
}
