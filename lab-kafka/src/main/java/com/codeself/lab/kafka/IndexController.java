package com.codeself.lab.kafka;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("title", "Kafka");
        model.addAttribute("description", "Producer, Consumer, Partition, Consumer Group");
        model.addAttribute("module", "lab-kafka");
        return "index";
    }
}
