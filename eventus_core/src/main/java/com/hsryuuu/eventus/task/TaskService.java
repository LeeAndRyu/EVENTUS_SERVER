package com.hsryuuu.eventus.task;

import com.hsryuuu.eventus.task.dto.CreateTaskRequest;
import com.hsryuuu.eventus.task.dto.TaskDto;
import com.hsryuuu.eventus.task.entity.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskDto createTask(CreateTaskRequest task) {
        Task entity = TaskMapper.toEntity(task);
        Task saved = taskRepository.save(entity);
        return TaskMapper.fromEntity(saved);
    }

    public List<TaskDto> getAllTasks(UUID userId) {
        return taskRepository.findByCreatorId(userId)
                .stream()
                .map(TaskMapper::fromEntity)
                .toList();
    }
}
