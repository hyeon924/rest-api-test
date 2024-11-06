package com.example.rest_api_test.article.response;

import com.example.rest_api_test.article.dto.ArticleDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

//    단건조회 응답객체
@Getter
@AllArgsConstructor
public class ArticleResponse { // ApiV1ArticleController에서 필요했던 static 삭제
    private  final ArticleDTO article;
}