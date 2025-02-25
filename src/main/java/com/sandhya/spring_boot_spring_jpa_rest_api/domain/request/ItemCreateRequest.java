package com.sandhya.spring_boot_spring_jpa_rest_api.domain.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ItemCreateRequest {

    private String itemName;

    private String lastModifiedUser;
}
