package ru.eipugf.gateway.domain.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.eipugf.gateway.domain.data.BaseTask;
import ru.eipugf.gateway.domain.service.TasksService;


@RestController
@RequestMapping("/api/")
public class TaskResource {

    private final TasksService tasksService;

    public TaskResource(TasksService tasksService) {
        this.tasksService = tasksService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getResult(@PathVariable("id") String id) {
        return new ResponseEntity<>(tasksService.findOne(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> accept(@RequestBody BaseTask request) {
        return new ResponseEntity<>(tasksService.accept(request), HttpStatus.CREATED);
    }
}
