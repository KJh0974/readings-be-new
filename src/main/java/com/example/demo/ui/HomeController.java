package com.example.demo.ui;

import com.example.demo.api.reading.ReadingService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    private ReadingService readingService;

    public HomeController(ReadingService readingService) {
        this.readingService = readingService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("readings", readingService.findAll());

        return "index";
    }
}
