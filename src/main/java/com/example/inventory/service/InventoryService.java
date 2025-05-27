package com.example.inventory.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.inventory.model.InventoryResponse;

@Service
public class InventoryService {
    private static final String API_URL = "https://jsonmock.hackerrank.com/api/inventory?page=%d";
    private final RestTemplate restTemplate = new RestTemplate();

    public InventoryResponse fetchInventory(int page) {
        String url = String.format(API_URL, page);
        return restTemplate.getForObject(url, InventoryResponse.class);
    }
}
