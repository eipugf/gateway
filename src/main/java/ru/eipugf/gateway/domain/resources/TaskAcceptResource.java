package ru.eipugf.gateway.domain.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.eipugf.gateway.domain.data.BaseTask;
import ru.eipugf.gateway.domain.service.TasksService;

@RestController
@RequestMapping("/api/")
public class TaskAcceptResource {

    private final TasksService tasksService;

    public TaskAcceptResource(TasksService tasksService) {
        this.tasksService = tasksService;
    }

    @PostMapping
    public ResponseEntity<String> accept(@RequestBody BaseTask request) {
        return new ResponseEntity<>(tasksService.accept(request), HttpStatus.CREATED);
    }
}
