package com.services.product.product_service.mapper;

import com.services.product.product_service.model.dto.ClientResponse;
import com.services.product.product_service.model.entity.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static com.services.product.product_service.utils.Constants.ACTIVE_STATUS;
import static com.services.product.product_service.utils.Constants.INACTIVE_STATUS;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    @Mapping(target = "status", expression = "java(mapStatus(client))")
    ClientResponse toClientResponse(Client client);

    default String mapStatus(Client client) {
        return client.getStatus() ? ACTIVE_STATUS : INACTIVE_STATUS;
    }
}