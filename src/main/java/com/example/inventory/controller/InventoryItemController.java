/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.example.inventory.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Inventorys Item", description = "Inventory Item management APIs")
@RequiredArgsConstructor
public class InventoryItemController {
    private final InventoryItemService inventoryItemService;

    @GetMapping
    @Operation(summary = "List all inventory items")
    public List<InventoryItem> getAllItems() {
        return inventoryItemService.getAllInventoryItems();
    }

    @GetMapping("/{barcode}")
    @Operation(summary = "List the first inventory item with the given barcode")
    @ResponseStatus(HttpStatus.OK)
    public InventoryItem getItemByBarcode(@PathVariable String barcode) {
        return inventoryItemService.getInventoryItemByBarcode(barcode);
    }

    @PostMapping
    @Operation(summary = "Add inventory item if it does not already exist")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<String> addItem(@RequestBody InventoryItem item) {
        if (inventoryItemService.isBarcodeExists(item.getBarcode())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Item with this barcode already exists.");
        }
        inventoryItemService.addInventoryItem(item);
        return ResponseEntity.status(HttpStatus.CREATED).body("Item added successfully.");
    }

    @PutMapping("/{barcode}")
    @Operation(summary = "Update inventory item by barcode")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> updateItem(@PathVariable String barcode, @RequestBody InventoryItem updatedItem) {
        if (!inventoryItemService.isBarcodeExists(barcode)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item not found.");
        }
        inventoryItemService.updateInventoryItem(barcode, updatedItem);
        return ResponseEntity.ok("Item updated successfully.");
    }

    @DeleteMapping("/{barcode}")
    @Operation(summary = "Delete inventory item by barcode")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<String> deleteItem(@PathVariable String barcode) {
        if (!inventoryItemService.isBarcodeExists(barcode)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Item not found.");
        }
        inventoryItemService.deleteInventoryItem(barcode);
        return ResponseEntity.ok("Item deleted successfully.");
    }

}
