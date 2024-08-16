package com.brunodias.template.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity(name = "categories")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Category extends BaseEntity {
    private String type;
    @OneToMany(mappedBy = "category")
    private List<Post> posts;
}
