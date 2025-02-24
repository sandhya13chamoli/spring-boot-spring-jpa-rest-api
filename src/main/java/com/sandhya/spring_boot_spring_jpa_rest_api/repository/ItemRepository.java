package com.sandhya.spring_boot_spring_jpa_rest_api.repository;

import com.sandhya.spring_boot_spring_jpa_rest_api.domain.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;


public interface ItemRepository extends JpaRepository<Item, UUID> {

    List<Item> findByItemName(String itemName);
}
