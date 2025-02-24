package com.sandhya.spring_boot_spring_jpa_rest_api.services.interfaceClasses;

import com.sandhya.spring_boot_spring_jpa_rest_api.domain.entity.Item;

import java.util.List;

public interface IItemService {

    public Item getItemById(String id);

    public Item createItem(Item item);

    Item updateItem(Item mappedItem);

    List<Item> getItemsByItemName(String itemName);
}
