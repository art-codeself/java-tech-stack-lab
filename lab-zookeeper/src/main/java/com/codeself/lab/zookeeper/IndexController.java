package com.codeself.lab.zookeeper;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("title", "Zookeeper");
        model.addAttribute("description", "Distributed Lock, Config Center with Curator");
        model.addAttribute("module", "lab-zookeeper");
        return "index";
    }
}
