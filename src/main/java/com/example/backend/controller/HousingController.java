package com.example.backend.controller;

import com.example.backend.entity.HousingLocation;
import com.example.backend.repository.HousingRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/locations")
@CrossOrigin(origins = "http://localhost:4200") // Angular app
public class HousingController {

    private final HousingRepository repository;

    public HousingController(HousingRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<HousingLocation> getAllLocations() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Optional<HousingLocation> getLocationById(@PathVariable Long id) {
        return repository.findById(id);
    }
}
