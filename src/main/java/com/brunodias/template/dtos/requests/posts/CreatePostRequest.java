package com.brunodias.template.dtos.requests.posts;

import com.brunodias.template.enums.CategoryPost;

public record CreatePostRequest(String title, String content, String url_image,String author,  CategoryPost category) {
}
