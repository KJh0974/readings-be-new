package com.example.demo.api.reading;

import com.example.demo.api.reading.model.Reading;
import com.example.demo.api.reading.model.ReadingAddable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/readings")
@CrossOrigin(value = "http://localhost:4200")
public class ReadingController {

    private ReadingService readingService;

    public ReadingController(ReadingService readingService) {
        this.readingService = readingService;
    }

    @GetMapping
    public List<Reading> getAll() {
        return readingService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reading> getById(@PathVariable("id") Long id) {
        return readingService.findById(id);
    }

    @PostMapping
    public Reading addReading(@RequestBody ReadingAddable reading) {
        return readingService.add(reading);
    }
}
