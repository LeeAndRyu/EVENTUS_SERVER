package com.hsryuuu.eventus.task;

import com.hsryuuu.eventus.task.dto.CreateTaskRequest;
import com.hsryuuu.eventus.task.dto.TaskDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Task API")
@RequiredArgsConstructor
@RequestMapping("/api/task")
@RestController
public class TaskController {

    private final TaskService taskService;


    @Operation(summary = "작업 생성")
    @PostMapping
    public TaskDto createTask(@RequestBody CreateTaskRequest task) {
        return taskService.createTask(task);
    }
}
