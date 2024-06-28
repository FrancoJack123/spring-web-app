package com.services.product.product_service.service;

import com.services.product.product_service.model.dto.ClientResponse;
import com.services.product.product_service.model.dto.CreateClientRequest;

import java.util.List;

public interface ClientService {
    ClientResponse findById(Long id);
    List<ClientResponse> findAll();
    ClientResponse save(CreateClientRequest request);
    ClientResponse update(Long id, CreateClientRequest request);
    void deleteById(Long id);
}