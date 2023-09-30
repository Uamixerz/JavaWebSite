package org.example.mappers;


import org.example.entities.CategoryEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    CategoryItemDTO categoryToItemDTO(CategoryEntity category);
    List<CategoryItemDTO> listCategoriesToItemDto(List<CategoryEntity> list);
}
