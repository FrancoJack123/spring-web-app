package com.services.product.product_service.mapper;

import com.services.product.product_service.model.dto.CategoryResponse;
import com.services.product.product_service.model.entity.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    CategoryResponse toCategoryResponse(Category category);

}
