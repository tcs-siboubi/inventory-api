package com.example.inventory.service;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import com.example.inventory.model.InventoryResponse;
import com.example.inventory.client.InventoryFeignClient;

@Service
@RequiredArgsConstructor
public class InventoryService {

    private final InventoryFeignClient inventoryFeignClient;

    public InventoryResponse fetchInventory(int page) {
        return inventoryFeignClient.getInventory(page);
    }
}
