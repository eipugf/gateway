package ru.eipugf.gateway.domain.resources;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.eipugf.gateway.domain.service.TasksService;

@RestController
@RequestMapping("/api/")
public class TaskResultsResource {

    private final TasksService tasksService;

    public TaskResultsResource(TasksService tasksService) {
        this.tasksService = tasksService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<?> getResult(@PathVariable("id") String id) {
        return new ResponseEntity<>(tasksService.findOne(id), HttpStatus.OK);
    }
}
