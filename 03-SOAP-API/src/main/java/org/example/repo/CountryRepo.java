package org.example.repo;

import jakarta.annotation.PostConstruct;
import org.example.model.Country;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CountryRepo {

    private static final Map<String, Country> countries = new HashMap<>();

    @PostConstruct
    public void initData() {
        // initialize countries map
    }

    public Country findCountry(String name) {
        return countries.get(name);
    }
}
