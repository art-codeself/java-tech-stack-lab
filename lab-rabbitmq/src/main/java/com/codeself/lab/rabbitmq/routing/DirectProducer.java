package com.codeself.lab.rabbitmq.routing;

import com.codeself.lab.rabbitmq.config.RabbitMQConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

/**
 * Routing (Direct) 模式 - 生产者。
 * 根据 routing key 精确路由到对应的队列。
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class DirectProducer {

    private final RabbitTemplate rabbitTemplate;

    public void send(String routingKey, String message) {
        log.info("[Routing] 发送消息, routingKey={}, message={}", routingKey, message);
        rabbitTemplate.convertAndSend(RabbitMQConfig.DIRECT_EXCHANGE, routingKey, message);
    }
}
