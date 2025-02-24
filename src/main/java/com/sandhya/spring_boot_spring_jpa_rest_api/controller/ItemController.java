package com.sandhya.spring_boot_spring_jpa_rest_api.controller;

import com.sandhya.spring_boot_spring_jpa_rest_api.domain.entity.Item;
import com.sandhya.spring_boot_spring_jpa_rest_api.mapper.ItemMapper;
import com.sandhya.spring_boot_spring_jpa_rest_api.services.interfaceClasses.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private IItemService iItemService;

    @Autowired
    private ItemMapper itemMapper;

    @RequestMapping(method = RequestMethod.POST)
    public Item createItem(@RequestBody Item item) {
        Item mappedItem = itemMapper.mapItemCreateRequest(item);
        return iItemService.createItem(mappedItem);
    }

    @RequestMapping(method=RequestMethod.PATCH, value = "/{id}")
    public Item updateItem(@PathVariable String id, @RequestBody Item item) {
        Item itemFromDB = iItemService.getItemById(id);
        Item mappedItem = itemMapper.mapItemUpdateRequest(itemFromDB, item);
        return iItemService.updateItem(mappedItem);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Item getItemById(@PathVariable String id) {
        return iItemService.getItemById(id);
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Item> getItemsByItemName(@RequestParam String itemName) {

        return iItemService.getItemsByItemName(itemName);
    }
}
