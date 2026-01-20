package com.example.backend.loader;

import com.example.backend.entity.HousingLocation;
import com.example.backend.repository.HousingRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    private final HousingRepository repository;

    public DataLoader(HousingRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        // Read JSON from resources
        InputStream inputStream = getClass().getResourceAsStream("/location.json");

        if (inputStream == null) {
            System.out.println("JSON file not found!");
            return;
        }

        // Read "locations" array from JSON
        List<HousingLocation> locations = mapper.readValue(
                mapper.readTree(inputStream).get("locations").toString(),
                new TypeReference<List<HousingLocation>>() {}
        );

        // Save to database
//        repository.saveAll(locations);
//
//        System.out.println("Locations saved to DB!");
    }
}
