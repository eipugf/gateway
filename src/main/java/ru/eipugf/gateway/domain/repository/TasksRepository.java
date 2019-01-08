package ru.eipugf.gateway.domain.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import ru.eipugf.gateway.TaskHolder;
import ru.eipugf.gateway.domain.data.BaseTask;

public interface TasksRepository extends ReactiveMongoRepository<TaskHolder<BaseTask>, String> {
}
