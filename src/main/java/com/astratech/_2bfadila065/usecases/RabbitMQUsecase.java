package com.astratech._2bfadila065.usecases;

import com.astratech._2bfadila065.services.RabbitMQService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class RabbitMQUsecase implements RabbitMQService {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public String publishMessage(String message) {
        rabbitTemplate.convertAndSend("myQueue", message);
        return "Message published to RabbitMQ";
    }

    @RabbitListener(queues = "myQueue")
    public String consumeMessage(String message) {
        System.out.println("Received message: " + message);
        return "Message consumed";
    }

    public String callExternalApi(String url) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, String.class);
    }
}
