package com.codeself.lab.rabbitmq.topic;

import com.codeself.lab.rabbitmq.config.RabbitMQConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

/**
 * Topic 模式 - 生产者。
 * 根据 routing key 通配符模式路由消息。
 * 绑定规则：*.error → 队列1，kern.* → 队列2
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class TopicProducer {

    private final RabbitTemplate rabbitTemplate;

    public void send(String routingKey, String message) {
        log.info("[Topic] 发送消息, routingKey={}, message={}", routingKey, message);
        rabbitTemplate.convertAndSend(RabbitMQConfig.TOPIC_EXCHANGE, routingKey, message);
    }
}
