package com.example.rest_api_test.article.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data // 기본적인 어노테이션이 다 들어가 있는 어노테이션
public class ArticleModifyRequest {
    @NotBlank
    private String subject;
    @NotBlank
    private String content;
}