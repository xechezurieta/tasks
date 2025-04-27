package com.xechezurieta.tasks.mappers;

import com.xechezurieta.tasks.domain.dto.TaskListDto;
import com.xechezurieta.tasks.domain.entities.TaskList;

public interface TaskListMapper {

    TaskList fromDto(TaskListDto taskListDto);

    TaskListDto toDto(TaskList taskList);
}
