/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.example.inventory.service;

import com.example.inventory.client.InventoryFeignClient;
import com.example.inventory.model.InventoryItem;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aideh
 */
@Service
@RequiredArgsConstructor
public class InventoryItemService {

    private final List<InventoryItem> items = new ArrayList<>();
    private final InventoryFeignClient inventoryFeignClient;

    public List<InventoryItem> getAllInventoryItems() {
        List<InventoryItem> inventoryItems = inventoryFeignClient.getInventory(1).getData();
        if (inventoryItems == null) {
            inventoryItems = new ArrayList<>();
        }
        // If you want to simulate a delay or some processing, you can uncomment the line below
        return inventoryItems;
    }

    public InventoryItem getInventoryItemByBarcode(String barcode) {
        return items.stream()
                .filter(item -> item.getBarcode().equals(barcode))
                .findFirst()
                .orElse(null);
    }

    public void addInventoryItem(InventoryItem item) {
        items.add(item);
    }

    public void updateInventoryItem(String barcode, InventoryItem updatedItem) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getBarcode().equals(barcode)) {
                items.set(i, updatedItem);
                return;
            }
        }
    }

    public void deleteInventoryItem(String barcode) {
        items.removeIf(item -> item.getBarcode().equals(barcode));
    }

    public boolean isBarcodeExists(String barcode) {
        return items.stream().anyMatch(item -> item.getBarcode().equals(barcode));
    }   
}
