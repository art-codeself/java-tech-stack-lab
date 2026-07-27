package com.codeself.lab.storage;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("title", "File Storage");
        model.addAttribute("description", "MinIO Upload/Download");
        model.addAttribute("module", "lab-file-storage");
        return "index";
    }
}
