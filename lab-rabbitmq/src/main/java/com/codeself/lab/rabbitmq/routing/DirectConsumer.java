package com.codeself.lab.rabbitmq.routing;

import com.codeself.lab.rabbitmq.config.RabbitMQConfig;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Routing (Direct) 模式 - 消费者。
 * 队列1 只接收 routingKey=error 的消息，
 * 队列2 只接收 routingKey=info 的消息。
 */
@Slf4j
@Component
public class DirectConsumer {

    @RabbitListener(queues = RabbitMQConfig.DIRECT_QUEUE_1)
    public void receiveError(String message, Channel channel,
                             @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag) throws IOException {
        log.info("[Routing] 错误队列 收到消息: {}", message);
        channel.basicAck(deliveryTag, false);
    }

    @RabbitListener(queues = RabbitMQConfig.DIRECT_QUEUE_2)
    public void receiveInfo(String message, Channel channel,
                            @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag) throws IOException {
        log.info("[Routing] 信息队列 收到消息: {}", message);
        channel.basicAck(deliveryTag, false);
    }
}
