package com.astratech._2bfadila065.controllers;

import com.astratech._2bfadila065.services.RabbitMQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rabbitmq")
public class RabbitMQController {
    @Autowired
    private RabbitMQService rabbitMQService;

    @PostMapping("/publish")
    public String publishMessage(@RequestBody String message) {
        return rabbitMQService.publishMessage(message);
    }
    @PostMapping("/consume")
    public String consumeMessage(@RequestBody String message) {
        return rabbitMQService.consumeMessage(message);
    }
    @GetMapping("/call")
    public String callExternalApi(@RequestBody String url) {
        return rabbitMQService.callExternalApi(url);
    }
}
