package com.xechezurieta.tasks.controllers;

import com.xechezurieta.tasks.domain.dto.TaskDto;
import com.xechezurieta.tasks.domain.entities.Task;
import com.xechezurieta.tasks.mappers.TaskMapper;
import com.xechezurieta.tasks.services.TaskService;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping(path = "/tasks-lists/{task_list_id}/tasks")
public class TaskController {

    private final TaskService taskService;
    private final TaskMapper taskMapper;


    public TaskController(TaskService taskService, TaskMapper taskMapper) {
        this.taskService = taskService;
        this.taskMapper = taskMapper;
    }

    @GetMapping
    public List<TaskDto> listTasks(@PathVariable("task_list_id")UUID taskListId) {
        return taskService.listTasks(taskListId)
                .stream()
                .map(taskMapper::toDto)
                .toList();
    }

    @PostMapping
    public TaskDto createTask(
            @PathVariable("task_list_id") UUID taskListId,
            @RequestBody TaskDto taskDto
    ) {
        Task createdTask = taskService.createTask(
                taskListId,
                taskMapper.fromDto(taskDto)
        );
        return taskMapper.toDto(createdTask);
    }

    @GetMapping(path = "/{task_id}")
    public Optional<TaskDto> getTask(
            @PathVariable("task_list_id") UUID taskListId,
            @PathVariable("task_id") UUID taskId
    ) {
        return taskService.getTask(taskListId, taskId)
                .map(taskMapper::toDto);

    }
}
