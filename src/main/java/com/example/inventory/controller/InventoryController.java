package com.example.inventory.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Inventory", description = "Inventory management APIs")
public class InventoryController {

    private final InventoryService service;

    @GetMapping
    @Operation(summary = "List all inventory items")
    public InventoryResponse getInventory(@RequestParam(defaultValue = "1") int page) {
        return service.fetchInventory(page);
    }
}
