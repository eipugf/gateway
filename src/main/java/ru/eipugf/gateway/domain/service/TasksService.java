package ru.eipugf.gateway.domain.service;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;
import ru.eipugf.gateway.TaskHolder;
import ru.eipugf.gateway.domain.data.BaseTask;
import ru.eipugf.gateway.domain.data.RegisterClient;
import ru.eipugf.gateway.domain.repository.TasksRepository;

import java.util.UUID;

@Service
public class TasksService {
    private final TasksRepository tasksRepository;

    private final RabbitTemplate rabbitTemplate;

    private final String exchange;

    private final String routingKey;

    public TasksService(TasksRepository tasksRepository,
                        RabbitTemplate rabbitTemplate,
                        @Value("${exchange.gateway}") String exchange,
                        @Value("${routing_key.gateway}") String routingKey) {
        this.tasksRepository = tasksRepository;
        this.rabbitTemplate = rabbitTemplate;
        this.exchange = exchange;
        this.routingKey = routingKey;
    }

    public Mono<TaskHolder<BaseTask>> findOne(String id) {
        return tasksRepository.findById(id);
    }

    public String accept (BaseTask request) {
        String id = UUID.randomUUID().toString();
        rabbitTemplate.convertAndSend(exchange, routingKey, new TaskHolder<>(id, request));
        return id;
    }

}
