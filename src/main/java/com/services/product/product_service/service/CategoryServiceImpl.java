package com.services.product.product_service.service;

import com.services.product.product_service.exceptions.CategoryNotFoundException;
import com.services.product.product_service.exceptions.ClientNotFoundException;
import com.services.product.product_service.mapper.CategoryMapper;
import com.services.product.product_service.mapper.ClientMapper;
import com.services.product.product_service.model.dto.CategoryResponse;
import com.services.product.product_service.model.dto.ClientResponse;
import com.services.product.product_service.model.dto.CreateCategoryRequest;
import com.services.product.product_service.model.dto.CreateClientRequest;
import com.services.product.product_service.model.entity.Category;
import com.services.product.product_service.model.entity.Client;
import com.services.product.product_service.repository.CategoryRepository;
import com.services.product.product_service.repository.ClientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{

    private final CategoryRepository categoryRepository;
    private final CategoryMapper categoryMapper;

    @Override
    public CategoryResponse findById(Long id) {
        return categoryRepository.findById(id)
                .map(categoryMapper::toCategoryResponse)
                .orElseThrow(CategoryNotFoundException::new);
    }

    @Override
    public List<CategoryResponse> findAll() {
        return categoryRepository.findAll()
                .stream()
                .map(categoryMapper::toCategoryResponse)
                .collect(Collectors.toList());
    }

    @Override
    public CategoryResponse save(CreateCategoryRequest request) {
        Category category = new Category();
        category.setName(request.getName());
        category.setDescription(request.getDescription());
        return categoryMapper.toCategoryResponse(categoryRepository.save(category));
    }

    @Override
    public CategoryResponse update(Long id, CreateCategoryRequest request) {
        return categoryRepository.findById(id)
                .map(category -> {
                    category.setName(request.getName());
                    category.setDescription(request.getDescription());
                    return categoryMapper.toCategoryResponse(categoryRepository.save(category));
                })
                .orElseThrow(CategoryNotFoundException::new);
    }

    @Override
    public void deleteById(Long id) {
        if(categoryRepository.findById(id).isEmpty()) {
            throw new CategoryNotFoundException();
        }
        categoryRepository.deleteById(id);
    }
}
