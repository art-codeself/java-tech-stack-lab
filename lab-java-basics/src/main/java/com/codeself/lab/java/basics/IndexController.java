package com.codeself.lab.java.basics;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("title", "Java Basics");
        model.addAttribute("description", "Collections, Generics, Reflection, Annotations, Stream API");
        model.addAttribute("module", "lab-java-basics");
        return "index";
    }
}
