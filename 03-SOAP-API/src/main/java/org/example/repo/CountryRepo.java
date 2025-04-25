package org.example.repo;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class CountryRepo {

    private static final Map<String, Country> countries = new HashMap<>();

    @PostConstruct
    public void initData() {
        // initialize countries map
        Country india = new Country();
        india.setName("India");
        india.setCapital("Delhi");
        india.setCurrency(Currency.INR);
        countries.put("India", india);
    }

    public Country findCountry(String name) {
        return countries.get(name);
    }
}
