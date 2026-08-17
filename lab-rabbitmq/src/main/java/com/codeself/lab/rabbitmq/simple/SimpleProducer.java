package com.codeself.lab.rabbitmq.simple;

import com.codeself.lab.rabbitmq.config.RabbitMQConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

/**
 * Simple Queue 模式 - 生产者。
 * 一对一直接发送到默认交换机的队列。
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class SimpleProducer {

    private final RabbitTemplate rabbitTemplate;

    public void send(String message) {
        log.info("[Simple] 发送消息: {}", message);
        rabbitTemplate.convertAndSend(RabbitMQConfig.SIMPLE_QUEUE, message);
    }
}
