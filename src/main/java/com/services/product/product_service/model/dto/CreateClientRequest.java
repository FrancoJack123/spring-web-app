package com.services.product.product_service.model.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Getter;


@Getter
@Builder
public class CreateClientRequest {

    @NotEmpty(message = "The field name cannot be empty or null.")
    private String name;

    @NotEmpty(message = "The field email cannot be empty or null.")
    private String email;

    @NotEmpty(message = "The field phone cannot be empty or null.")
    private String phone;
}