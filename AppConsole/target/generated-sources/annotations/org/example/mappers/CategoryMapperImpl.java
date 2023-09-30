package org.example.mappers;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.example.entities.CategoryEntity;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-30T16:53:43+0300",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 20.0.2 (Oracle Corporation)"
)
@Component
public class CategoryMapperImpl implements CategoryMapper {

    @Override
    public CategoryItemDTO categoryToItemDTO(CategoryEntity category) {
        if ( category == null ) {
            return null;
        }

        CategoryItemDTO categoryItemDTO = new CategoryItemDTO();

        categoryItemDTO.setId( category.getId() );
        categoryItemDTO.setName( category.getName() );
        categoryItemDTO.setImage( category.getImage() );
        categoryItemDTO.setDescription( category.getDescription() );

        return categoryItemDTO;
    }

    @Override
    public List<CategoryItemDTO> listCategoriesToItemDto(List<CategoryEntity> list) {
        if ( list == null ) {
            return null;
        }

        List<CategoryItemDTO> list1 = new ArrayList<CategoryItemDTO>( list.size() );
        for ( CategoryEntity categoryEntity : list ) {
            list1.add( categoryToItemDTO( categoryEntity ) );
        }

        return list1;
    }
}
