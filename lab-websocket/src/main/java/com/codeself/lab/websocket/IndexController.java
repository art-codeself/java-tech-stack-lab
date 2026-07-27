package com.codeself.lab.websocket;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("title", "WebSocket");
        model.addAttribute("description", "Real-time Communication, Chat Room, Message Push");
        model.addAttribute("module", "lab-websocket");
        return "index";
    }
}
