package org.example.dto.category;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;

@Data
public class CategoryCreateDTO {
    private String name;
    private LocalDateTime dateCreate;
    private String description;
    private MultipartFile image;
}
