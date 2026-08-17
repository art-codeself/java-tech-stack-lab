package com.codeself.lab.rabbitmq.topic;

import com.codeself.lab.rabbitmq.config.RabbitMQConfig;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Topic 模式 - 消费者。
 * 队列1 绑定 *.error，匹配如 app.error、db.error
 * 队列2 绑定 kern.*，匹配如 kern.critical、 kern.warning
 */
@Slf4j
@Component
public class TopicConsumer {

    @RabbitListener(queues = RabbitMQConfig.TOPIC_QUEUE_1)
    public void receiveError(String message, Channel channel,
                             @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag) throws IOException {
        log.info("[Topic] 错误队列(*.error) 收到消息: {}", message);
        channel.basicAck(deliveryTag, false);
    }

    @RabbitListener(queues = RabbitMQConfig.TOPIC_QUEUE_2)
    public void receiveKern(String message, Channel channel,
                            @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag) throws IOException {
        log.info("[Topic] 内核队列(kern.*) 收到消息: {}", message);
        channel.basicAck(deliveryTag, false);
    }
}
