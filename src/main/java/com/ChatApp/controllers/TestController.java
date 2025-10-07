package com.ChatApp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/ws-chat/info")
    public String testInfo() {
        return "WebSocket info endpoint alive";
    }
}

