package com.codeself.lab.java.pattern;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("title", "Design Patterns");
        model.addAttribute("description", "Singleton, Factory, Strategy, Observer, and more");
        model.addAttribute("module", "lab-java-design-pattern");
        return "index";
    }
}
