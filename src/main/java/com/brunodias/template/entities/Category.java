package com.brunodias.template.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

import com.brunodias.template.enums.CategoryPost;

@Entity(name = "categories")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category extends BaseEntity {

    @Column(nullable = false)
    @Enumerated(EnumType.STRING) // especificar como um campo do tipo enum deve ser mapeado para uma coluna em um
    private CategoryPost type;
    @OneToMany(mappedBy = "category")
    private List<Post> posts;
}
