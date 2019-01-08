package ru.eipugf.gateway.domain.service;


import org.springframework.stereotype.Service;
import ru.eipugf.gateway.domain.data.BaseTask;
import ru.eipugf.gateway.domain.data.RegisterClient;

import java.util.UUID;

@Service
public class TasksService {


    public BaseTask findOne(String id) {
        return new RegisterClient();
    }

    public String accept (BaseTask request) {
        return UUID.randomUUID().toString();
    }

}
