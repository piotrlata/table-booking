package com.example.tablebooking.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedirectConfig {
    @GetMapping
    public String redirectToSwagger() {
        return "redirect:/swagger-ui.html";
    }
}
