package com.brunodias.template.services;

import com.brunodias.template.dtos.requests.posts.CreatePostRequest;
import com.brunodias.template.entities.Post;
import com.brunodias.template.entities.User;
import com.brunodias.template.repositories.CategoryRepository;
import com.brunodias.template.repositories.PostRepository;
import com.brunodias.template.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PostService {

    @Autowired
    private PostRepository _postRepository;
    @Autowired
    private UserRepository _userRepository;
    @Autowired
    private CategoryRepository _categoryRepository;

    public Post createPost(CreatePostRequest request) {
        var authorExist = this._userRepository.findByEmail(request.author());
        var category = this._categoryRepository.findByName(request.category());

        var post = Post.builder().title(request.title()).content(request.content()).author((User) authorExist)
                .category(request.category()).build();
    }
}
