package com.example.rest_api_test.article.response;

import com.example.rest_api_test.article.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ArticleCreateResponse {
    private final Article article;
}