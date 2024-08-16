package com.brunodias.template.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
@Entity(name = "posts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Post extends BaseEntity{
    private String title;
    private String content;
    private String urlImage;
    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
    private LocalDateTime createdDate;
    @OneToMany(mappedBy = "post")
    private List<Comment> comments;


}
