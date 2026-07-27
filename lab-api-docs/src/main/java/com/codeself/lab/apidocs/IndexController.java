package com.codeself.lab.apidocs;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("title", "API Docs");
        model.addAttribute("description", "Swagger / Knife4j Documentation");
        model.addAttribute("module", "lab-api-docs");
        return "index";
    }
}
