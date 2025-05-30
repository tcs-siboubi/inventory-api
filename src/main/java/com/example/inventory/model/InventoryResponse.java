package com.example.inventory.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class InventoryResponse {
    private int page;
    private int total;
    private int total_pages;
    private List<InventoryItem> data;

}
