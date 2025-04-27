package com.xechezurieta.tasks.mappers;

import com.xechezurieta.tasks.domain.dto.TaskDto;
import com.xechezurieta.tasks.domain.entities.Task;

public interface TaskMapper {

    Task fromDto(TaskDto taskDto);

    TaskDto toDto(Task task);
}
