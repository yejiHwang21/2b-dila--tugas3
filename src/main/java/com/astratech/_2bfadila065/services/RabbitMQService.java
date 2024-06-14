package com.astratech._2bfadila065.services;

public interface RabbitMQService {
    public String publishMessage(String message);
    public String consumeMessage(String message);
    public String callExternalApi(String url);
}
