package com.codeself.lab.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * RabbitMQ 五种模式的队列、交换机、绑定关系声明。
 */
@Configuration
public class RabbitMQConfig {

    // ======================== 1. Simple Queue ========================

    public static final String SIMPLE_QUEUE = "lab.simple.queue";

    @Bean
    public Queue simpleQueue() {
        return QueueBuilder.durable(SIMPLE_QUEUE).build();
    }

    // ======================== 2. Work Queue ========================

    public static final String WORK_QUEUE = "lab.work.queue";

    @Bean
    public Queue workQueue() {
        return QueueBuilder.durable(WORK_QUEUE).build();
    }

    // ======================== 3. Pub/Sub (Fanout) ========================

    public static final String FANOUT_EXCHANGE = "lab.fanout.exchange";
    public static final String FANOUT_QUEUE_1 = "lab.fanout.queue1";
    public static final String FANOUT_QUEUE_2 = "lab.fanout.queue2";

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange(FANOUT_EXCHANGE);
    }

    @Bean
    public Queue fanoutQueue1() {
        return QueueBuilder.durable(FANOUT_QUEUE_1).build();
    }

    @Bean
    public Queue fanoutQueue2() {
        return QueueBuilder.durable(FANOUT_QUEUE_2).build();
    }

    @Bean
    public Binding fanoutBinding1() {
        return BindingBuilder.bind(fanoutQueue1()).to(fanoutExchange());
    }

    @Bean
    public Binding fanoutBinding2() {
        return BindingBuilder.bind(fanoutQueue2()).to(fanoutExchange());
    }

    // ======================== 4. Routing (Direct) ========================

    public static final String DIRECT_EXCHANGE = "lab.direct.exchange";
    public static final String DIRECT_QUEUE_1 = "lab.direct.queue1";
    public static final String DIRECT_QUEUE_2 = "lab.direct.queue2";
    public static final String ROUTING_KEY_ERROR = "error";
    public static final String ROUTING_KEY_INFO = "info";

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange(DIRECT_EXCHANGE);
    }

    @Bean
    public Queue directQueue1() {
        return QueueBuilder.durable(DIRECT_QUEUE_1).build();
    }

    @Bean
    public Queue directQueue2() {
        return QueueBuilder.durable(DIRECT_QUEUE_2).build();
    }

    @Bean
    public Binding directBinding1() {
        return BindingBuilder.bind(directQueue1()).to(directExchange()).with(ROUTING_KEY_ERROR);
    }

    @Bean
    public Binding directBinding2() {
        return BindingBuilder.bind(directQueue2()).to(directExchange()).with(ROUTING_KEY_INFO);
    }

    // ======================== 5. Topic ========================

    public static final String TOPIC_EXCHANGE = "lab.topic.exchange";
    public static final String TOPIC_QUEUE_1 = "lab.topic.queue1";
    public static final String TOPIC_QUEUE_2 = "lab.topic.queue2";

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(TOPIC_EXCHANGE);
    }

    @Bean
    public Queue topicQueue1() {
        return QueueBuilder.durable(TOPIC_QUEUE_1).build();
    }

    @Bean
    public Queue topicQueue2() {
        return QueueBuilder.durable(TOPIC_QUEUE_2).build();
    }

    @Bean
    public Binding topicBinding1() {
        return BindingBuilder.bind(topicQueue1()).to(topicExchange()).with("*.error");
    }

    @Bean
    public Binding topicBinding2() {
        return BindingBuilder.bind(topicQueue2()).to(topicExchange()).with("kern.*");
    }
}
