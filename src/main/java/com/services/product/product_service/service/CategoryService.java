package com.services.product.product_service.service;

import com.services.product.product_service.model.dto.CategoryResponse;
import com.services.product.product_service.model.dto.ClientResponse;
import com.services.product.product_service.model.dto.CreateCategoryRequest;
import com.services.product.product_service.model.dto.CreateClientRequest;

import java.util.List;

public interface CategoryService {
    CategoryResponse findById(Long id);
    List<CategoryResponse> findAll();
    CategoryResponse save(CreateCategoryRequest request);
    CategoryResponse update(Long id, CreateCategoryRequest request);
    void deleteById(Long id);
}