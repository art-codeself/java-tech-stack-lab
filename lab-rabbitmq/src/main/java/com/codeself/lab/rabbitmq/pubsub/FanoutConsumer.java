package com.codeself.lab.rabbitmq.pubsub;

import com.codeself.lab.rabbitmq.config.RabbitMQConfig;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Pub/Sub (Fanout) 模式 - 消费者。
 * 两个队列各绑定一个消费者，都能收到完整的广播消息。
 */
@Slf4j
@Component
public class FanoutConsumer {

    @RabbitListener(queues = RabbitMQConfig.FANOUT_QUEUE_1)
    public void receive1(String message, Channel channel,
                         @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag) throws IOException {
        log.info("[PubSub] 消费者1 收到消息: {}", message);
        channel.basicAck(deliveryTag, false);
    }

    @RabbitListener(queues = RabbitMQConfig.FANOUT_QUEUE_2)
    public void receive2(String message, Channel channel,
                         @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag) throws IOException {
        log.info("[PubSub] 消费者2 收到消息: {}", message);
        channel.basicAck(deliveryTag, false);
    }
}
