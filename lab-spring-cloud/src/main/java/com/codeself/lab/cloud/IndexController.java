package com.codeself.lab.cloud;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("title", "Spring Cloud");
        model.addAttribute("description", "Nacos, Gateway, Feign, Sentinel");
        model.addAttribute("module", "lab-spring-cloud");
        return "index";
    }
}
