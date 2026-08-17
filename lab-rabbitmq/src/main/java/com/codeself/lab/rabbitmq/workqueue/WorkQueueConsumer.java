package com.codeself.lab.rabbitmq.workqueue;

import com.codeself.lab.rabbitmq.config.RabbitMQConfig;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * Work Queue 模式 - 消费者。
 * 两个消费者实例竞争消费同一队列中的消息，演示轮询分发。
 * 可通过启动多个应用实例观察竞争效果。
 */
@Slf4j
@Component
public class WorkQueueConsumer {

    @RabbitListener(queues = RabbitMQConfig.WORK_QUEUE)
    public void receive(String message, Channel channel,
                        @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag) throws IOException {
        log.info("[WorkQueue] 收到消息: {}", message);
        // 模拟耗时处理
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        channel.basicAck(deliveryTag, false);
        log.info("[WorkQueue] 消息处理完成, deliveryTag={}", deliveryTag);
    }
}
