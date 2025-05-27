/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.example.inventory.client;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;
import com.example.inventory.model.InventoryResponse;
import static java.util.Collections.emptyList;

/**
 *
 * @author aideh
 */
@Component
@Slf4j
public class InventoryFallbackFactory implements FallbackFactory<InventoryFeignClient> {

    @Override
    public InventoryFeignClient create(Throwable cause) {
        return page ->  {
            log.error("Error fetching inventory for page {}: {}", page, cause.getMessage());
            InventoryResponse response = new InventoryResponse();
            response.setPage(page);
            response.setTotal(0);
            response.setTotal_pages(0);
            response.setData(emptyList()); // or an empty list if preferred
            return response;
        };
    }

}
