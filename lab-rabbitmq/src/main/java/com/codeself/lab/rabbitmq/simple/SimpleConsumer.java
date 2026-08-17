package com.codeself.lab.rabbitmq.simple;

import com.codeself.lab.rabbitmq.config.RabbitMQConfig;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Simple Queue 模式 - 消费者。
 * 监听默认交换机队列，手动 ACK。
 */
@Slf4j
@Component
public class SimpleConsumer {

    @RabbitListener(queues = RabbitMQConfig.SIMPLE_QUEUE)
    public void receive(String message, Channel channel,
                        @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag) throws IOException {
        log.info("[Simple] 收到消息: {}", message);
        channel.basicAck(deliveryTag, false);
        log.info("[Simple] 消息已确认, deliveryTag={}", deliveryTag);
    }
}
