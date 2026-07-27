package com.codeself.lab.rabbitmq;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("title", "RabbitMQ");
        model.addAttribute("description", "Simple Queue, Work Queue, Pub/Sub, Routing, Topic");
        model.addAttribute("module", "lab-rabbitmq");
        return "index";
    }
}
