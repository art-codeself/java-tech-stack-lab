package com.codeself.lab.mysql;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("title", "MySQL + MyBatis-Plus");
        model.addAttribute("description", "CRUD, Pagination, Transactions");
        model.addAttribute("module", "lab-mysql");
        return "index";
    }
}
