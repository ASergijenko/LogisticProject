package com.cargoproject.logisticproject.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Map;

@Controller
public class MainController {

    @GetMapping("/")
    public String startPage(Map<String, Object> model) {
        return "startPage";
    }
}