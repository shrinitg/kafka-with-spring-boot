package com.example.kafkaTest.controller;

import com.example.kafkaTest.service.GeneralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class GeneralController {

    @Autowired
    private GeneralService generalService;

    @GetMapping("/publish")
    public void sendToKafka(@RequestParam String message) {
        generalService.publishToKafka(message);
    }

}
