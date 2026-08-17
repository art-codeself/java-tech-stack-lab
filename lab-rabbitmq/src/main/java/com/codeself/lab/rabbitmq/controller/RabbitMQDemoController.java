package com.codeself.lab.rabbitmq.controller;

import com.codeself.lab.rabbitmq.pubsub.FanoutProducer;
import com.codeself.lab.rabbitmq.routing.DirectProducer;
import com.codeself.lab.rabbitmq.simple.SimpleProducer;
import com.codeself.lab.rabbitmq.topic.TopicProducer;
import com.codeself.lab.rabbitmq.workqueue.WorkQueueProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * RabbitMQ 五种模式的 REST API 演示入口。
 */
@RestController
@RequestMapping("/rabbitmq")
@RequiredArgsConstructor
public class RabbitMQDemoController {

    private final SimpleProducer simpleProducer;
    private final WorkQueueProducer workQueueProducer;
    private final FanoutProducer fanoutProducer;
    private final DirectProducer directProducer;
    private final TopicProducer topicProducer;

    /**
     * 1. Simple Queue - 一对一发送
     * GET /rabbitmq/simple/send?msg=hello
     */
    @GetMapping("/simple/send")
    public String simpleSend(@RequestParam(defaultValue = "hello simple") String msg) {
        simpleProducer.send(msg);
        return "Simple message sent: " + msg;
    }

    /**
     * 2. Work Queue - 竞争消费
     * GET /rabbitmq/workqueue/send?msg=task1&count=5
     */
    @GetMapping("/workqueue/send")
    public String workQueueSend(@RequestParam(defaultValue = "task") String msg,
                                @RequestParam(defaultValue = "3") int count) {
        for (int i = 1; i <= count; i++) {
            workQueueProducer.send(msg + "-" + i);
        }
        return "WorkQueue messages sent: " + count + " tasks";
    }

    /**
     * 3. Pub/Sub (Fanout) - 广播
     * GET /rabbitmq/pubsub/send?msg=broadcast
     */
    @GetMapping("/pubsub/send")
    public String pubsubSend(@RequestParam(defaultValue = "broadcast message") String msg) {
        fanoutProducer.send(msg);
        return "PubSub message sent: " + msg;
    }

    /**
     * 4. Routing (Direct) - 按 routing key 精确路由
     * GET /rabbitmq/routing/send?key=error&msg=alert
     */
    @GetMapping("/routing/send")
    public String routingSend(@RequestParam(defaultValue = "error") String key,
                              @RequestParam(defaultValue = "routing message") String msg) {
        directProducer.send(key, msg);
        return "Routing message sent: key=" + key + ", msg=" + msg;
    }

    /**
     * 5. Topic - 按通配符路由
     * GET /rabbitmq/topic/send?key=kern.critical&msg=panic
     */
    @GetMapping("/topic/send")
    public String topicSend(@RequestParam(defaultValue = "kern.critical") String key,
                            @RequestParam(defaultValue = "topic message") String msg) {
        topicProducer.send(key, msg);
        return "Topic message sent: key=" + key + ", msg=" + msg;
    }
}
