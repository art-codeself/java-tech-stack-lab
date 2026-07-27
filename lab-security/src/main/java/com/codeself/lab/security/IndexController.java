package com.codeself.lab.security;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("title", "Spring Security");
        model.addAttribute("description", "Authentication, Authorization, JWT, OAuth2");
        model.addAttribute("module", "lab-security");
        return "index";
    }
}
