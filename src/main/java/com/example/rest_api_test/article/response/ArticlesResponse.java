package com.example.rest_api_test.article.response;

import com.example.rest_api_test.article.dto.ArticleDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

//    다건조회 응답객체
@AllArgsConstructor
@Getter
public class ArticlesResponse {  // ApiV1ArticleController에서 필요했던 static 삭제
    private final List<ArticleDTO> articleList;
}
