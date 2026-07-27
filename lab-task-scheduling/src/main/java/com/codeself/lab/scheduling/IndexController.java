package com.codeself.lab.scheduling;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("title", "Task Scheduling");
        model.addAttribute("description", "Spring Scheduled, Quartz");
        model.addAttribute("module", "lab-task-scheduling");
        return "index";
    }
}
