package com.sandhya.spring_boot_spring_jpa_rest_api.services;

import com.sandhya.spring_boot_spring_jpa_rest_api.domain.entity.Item;
import com.sandhya.spring_boot_spring_jpa_rest_api.repository.ItemRepository;
import com.sandhya.spring_boot_spring_jpa_rest_api.services.interfaceClasses.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ItemService implements IItemService {

    @Autowired
    private ItemRepository itemRepository;

    public Item createItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public Item updateItem(Item item) {
        return itemRepository.save(item);
    }

    @Override
    public List<Item> getItemsByItemName(String itemName) {
        return itemRepository.findByItemName(itemName);
    }

    @Override
    public Item getItemById(String id) {
        return itemRepository.findById(UUID.fromString(id)).get();
    }


}
