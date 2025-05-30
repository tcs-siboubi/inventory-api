/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.example.inventory.controller;

import com.example.inventory.model.InventoryItem;
import com.example.inventory.service.InventoryItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 *
 * @author aideh
 */
@RestController
@RequestMapping("/inventory/items")
@RequiredArgsConstructor
public class InventoryItemController {
    private final InventoryItemService inventoryItemService;

    @GetMapping
    public List<InventoryItem> getAllItems() {
        return inventoryItemService.getAllInventoryItems();
    }

    @GetMapping("/{barcode}")
    public InventoryItem getItemByBarcode(@PathVariable String barcode) {
        return inventoryItemService.getInventoryItemByBarcode(barcode);
    }

    @PostMapping
    public ResponseEntity<String> addItem(@RequestBody InventoryItem item) {
        if (inventoryItemService.isBarcodeExists(item.getBarcode())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Item with this barcode already exists.");
        }
        inventoryItemService.addInventoryItem(item);
        return ResponseEntity.status(HttpStatus.CREATED).body("Item added successfully.");
    }

    @PutMapping("/{barcode}")
    public ResponseEntity<String> updateItem(@PathVariable String barcode, @RequestBody InventoryItem updatedItem) {
        if (!inventoryItemService.isBarcodeExists(barcode)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item not found.");
        }
        inventoryItemService.updateInventoryItem(barcode, updatedItem);
        return ResponseEntity.ok("Item updated successfully.");
    }

    @DeleteMapping("/{barcode}")
    public ResponseEntity<String> deleteItem(@PathVariable String barcode) {
        if (!inventoryItemService.isBarcodeExists(barcode)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item not found.");
        }
        inventoryItemService.deleteInventoryItem(barcode);
        return ResponseEntity.ok("Item deleted successfully.");
    }

}
