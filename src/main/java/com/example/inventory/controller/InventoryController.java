package com.example.inventory.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.inventory.model.InventoryResponse;
import com.example.inventory.service.InventoryService;

@RestController
@RequestMapping("/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService service;

    @GetMapping
    public InventoryResponse getInventory(@RequestParam(defaultValue = "1") int page) {
        return service.fetchInventory(page);
    }
}
