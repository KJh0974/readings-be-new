package com.example.demo.api.object;

import com.example.demo.api.object.model.ObjectModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/objects")
@CrossOrigin(value = "http://localhost:4200")
public class ObjectController {

    private ObjectService objectService;

    public ObjectController(ObjectService objectService) {
        this.objectService = objectService;
    }

    @GetMapping
    public List<ObjectModel> getAll() {
        return objectService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ObjectModel> getById(@PathVariable("id") Long id) {
        return objectService.findContract(id);
    }
}
