package com.sandhya.spring_boot_spring_jpa_rest_api.mapper;

import com.sandhya.spring_boot_spring_jpa_rest_api.domain.entity.Item;
import com.sandhya.spring_boot_spring_jpa_rest_api.domain.request.ItemCreateRequest;
import com.sandhya.spring_boot_spring_jpa_rest_api.domain.request.ItemUpdateRequest;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class ItemMapper {

    public Item mapItemCreateRequest(ItemCreateRequest item) {
        return Item.builder()
                .itemName(item.getItemName())
                .lastModifiedUser(item.getLastModifiedUser())
                .createdDateTime(new Date())
                .lastModifiedDateTime(new Date())
                .build();
    }

    public Item mapItemUpdateRequest(Item itemFromDB, ItemUpdateRequest item) {
        return Item.builder()
                .id(itemFromDB.getId())
                .itemName(item.getItemName())
                .lastModifiedDateTime(new Date())
                .lastModifiedUser(item.getLastModifiedUser())
                .createdDateTime(itemFromDB.getCreatedDateTime())
                .build();
    }
}
