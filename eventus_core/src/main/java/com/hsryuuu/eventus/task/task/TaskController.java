package com.hsryuuu.eventus.task.task;

import com.hsryuuu.eventus.appllication.security.SecurityUtils;
import com.hsryuuu.eventus.task.task.dto.CreateTaskRequest;
import com.hsryuuu.eventus.task.task.dto.TaskDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Tag(name = "작업(TODO) API")
@RequiredArgsConstructor
@RequestMapping("/api/tasks")
@RestController
public class TaskController {

    private final TaskService taskService;

    @Operation(summary = "작업 생성")
    @PostMapping
    public TaskDto createTask(@RequestBody CreateTaskRequest task) {
        return taskService.createTask(task);
    }

    @Operation(summary = "작업 조회", description = "(임시) 추후 조회 전략 필요")
    @GetMapping
    public List<TaskDto> getAllTasks(@RequestParam(required = false) UUID userId) {
        if (userId == null) {
            Optional<UUID> loginUserId = SecurityUtils.getCurrentUserId();
            userId = loginUserId.orElse(null);
        }
        return taskService.getAllTasks(userId);
    }

}
