package com.codeself.lab.rabbitmq.workqueue;

import com.codeself.lab.rabbitmq.config.RabbitMQConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

/**
 * Work Queue 模式 - 生产者。
 * 向同一个队列发送多条消息，多个消费者竞争消费。
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class WorkQueueProducer {

    private final RabbitTemplate rabbitTemplate;

    public void send(String message) {
        log.info("[WorkQueue] 发送消息: {}", message);
        rabbitTemplate.convertAndSend(RabbitMQConfig.WORK_QUEUE, message);
    }
}
