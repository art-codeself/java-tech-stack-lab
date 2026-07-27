package com.codeself.lab.java.concurrent;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("title", "Java Concurrent");
        model.addAttribute("description", "Thread Pool, CompletableFuture, Locks, Concurrent Utilities");
        model.addAttribute("module", "lab-java-concurrent");
        return "index";
    }
}
