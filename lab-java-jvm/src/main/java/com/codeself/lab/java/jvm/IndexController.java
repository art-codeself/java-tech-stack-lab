package com.codeself.lab.java.jvm;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("title", "Java JVM");
        model.addAttribute("description", "JVM Tuning, GC, Class Loading, OOM Scenarios");
        model.addAttribute("module", "lab-java-jvm");
        return "index";
    }
}
