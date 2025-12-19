package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

@RestController
public class ResourceController {

    @GetMapping("/resource-status")
    public Map<String, String> getResourceStatus() {
        return Map.of("message", "Pong");
    }
}
