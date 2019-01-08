package ru.eipugf.gateway.domain.service;


import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.eipugf.gateway.TaskHolder;
import ru.eipugf.gateway.domain.data.BaseTask;
import ru.eipugf.gateway.domain.data.RegisterClient;

import java.util.UUID;

@Service
public class TasksService {

    private final RabbitTemplate rabbitTemplate;

    private final String exchange;

    private final String routingKey;

    public TasksService(RabbitTemplate rabbitTemplate,
                        @Value("${exchange.gateway}") String exchange,
                        @Value("${routing_key.gateway}") String routingKey) {
        this.rabbitTemplate = rabbitTemplate;
        this.exchange = exchange;
        this.routingKey = routingKey;
    }

    public BaseTask findOne(String id) {
        return new RegisterClient();
    }

    public String accept (BaseTask request) {
        String id = UUID.randomUUID().toString();
        rabbitTemplate.convertAndSend(exchange, routingKey, new TaskHolder<>(id, request));
        return id;
    }

}
