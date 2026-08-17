package com.codeself.lab.rabbitmq.pubsub;

import com.codeself.lab.rabbitmq.config.RabbitMQConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

/**
 * Pub/Sub (Fanout) 模式 - 生产者。
 * 发送到 Fanout 交换机，所有绑定队列都会收到消息。
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class FanoutProducer {

    private final RabbitTemplate rabbitTemplate;

    public void send(String message) {
        log.info("[PubSub] 发送广播消息: {}", message);
        rabbitTemplate.convertAndSend(RabbitMQConfig.FANOUT_EXCHANGE, "", message);
    }
}
