package com.services.product.product_service.controller;

import com.services.product.product_service.model.dto.CategoryResponse;
import com.services.product.product_service.model.dto.ClientResponse;
import com.services.product.product_service.model.dto.CreateCategoryRequest;
import com.services.product.product_service.model.dto.CreateClientRequest;
import com.services.product.product_service.service.CategoryService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/category")
@PreAuthorize("hasAnyRole('ADMIN','USER')")
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    List<CategoryResponse> findAll() {
        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public CategoryResponse findById(@PathVariable long id) {
        return categoryService.findById(id);
    }

    @PostMapping()
    public ResponseEntity<CategoryResponse> save(@Valid @RequestBody CreateCategoryRequest request) {
        CategoryResponse response = categoryService.save(request);
        return ResponseEntity
                .created(URI.create("api/category/" + response.getId()))
                .body(response);
    }

    @PutMapping("/{id}")
    public CategoryResponse update(
            @PathVariable Long id, @Valid @RequestBody CreateCategoryRequest request) {
        return categoryService.update(id, request);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteById(@PathVariable long id) {
        categoryService.deleteById(id);
        return ResponseEntity.ok("Categoria eliminada correctamente");
    }
}

