package _2025.fullstack.backend.domain.user.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/api")
public class HealthCheck {

    @GetMapping("/healthCheck")
    public String healthCheck(){
        return "health-check";
    }
}