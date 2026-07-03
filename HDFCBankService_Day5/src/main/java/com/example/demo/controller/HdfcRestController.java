package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hdfc")
public class HdfcRestController {

    @GetMapping("/getData")
    public String getData() {
        return "Returning Data from HDFC-BANK-SERVICE";
    }
}
