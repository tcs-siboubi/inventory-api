/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.example.inventory.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.inventory.model.InventoryResponse;

/**
 *
 * @author aideh
 */
@FeignClient(name = "inventoryClient", url = "https://jsonmock.hackerrank.com")
public interface InventoryFeignClient {
    
    @GetMapping("/api/inventory")
    InventoryResponse getInventory(@RequestParam("page") int page);

}
