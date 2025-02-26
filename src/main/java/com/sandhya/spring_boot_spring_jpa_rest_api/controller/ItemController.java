package com.sandhya.spring_boot_spring_jpa_rest_api.controller;

import com.sandhya.spring_boot_spring_jpa_rest_api.domain.entity.Item;
import com.sandhya.spring_boot_spring_jpa_rest_api.domain.request.ItemCreateRequest;
import com.sandhya.spring_boot_spring_jpa_rest_api.domain.request.ItemUpdateRequest;
import com.sandhya.spring_boot_spring_jpa_rest_api.mapper.ItemMapper;
import com.sandhya.spring_boot_spring_jpa_rest_api.services.interfaceClasses.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Item> createItem(@RequestBody ItemCreateRequest item) {
        Item mappedItem = itemMapper.mapItemCreateRequest(item);
        return new ResponseEntity<>(iItemService.createItem(mappedItem), HttpStatus.CREATED);
    }

    @RequestMapping(method=RequestMethod.PATCH, value = "/{id}")
    public ResponseEntity<Item> updateItem(@PathVariable String id, @RequestBody ItemUpdateRequest item) {
        Item itemFromDB = iItemService.getItemById(id);
        Item mappedItem = itemMapper.mapItemUpdateRequest(itemFromDB, item);
        return new ResponseEntity<>(iItemService.updateItem(mappedItem), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<Item> getItemById(@PathVariable String id) {
        return new ResponseEntity<>(iItemService.getItemById(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<List<Item>> getItemsByItemName(@RequestParam String itemName) {
        return new ResponseEntity<>(iItemService.getItemsByItemName(itemName), HttpStatus.OK);
    }
}
