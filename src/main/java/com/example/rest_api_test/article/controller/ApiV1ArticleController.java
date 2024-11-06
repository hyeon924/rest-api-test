package com.example.rest_api_test.article.controller;

import com.example.rest_api_test.article.dto.ArticleDTO;
import com.example.rest_api_test.article.entity.Article;
import com.example.rest_api_test.article.request.ArticleCreateRequest;
import com.example.rest_api_test.article.request.ArticleModifyRequest;
import com.example.rest_api_test.article.response.ArticleCreateResponse;
import com.example.rest_api_test.article.response.ArticleResponse;
import com.example.rest_api_test.article.response.ArticlesResponse;
import com.example.rest_api_test.article.service.ArticleService;
import com.example.rest_api_test.global.RsData.RsData;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/articles")
public class ApiV1ArticleController {

    private final ArticleService articleService;

//    다건조회
    @GetMapping("")
    public RsData<ArticlesResponse> list() {
        List<ArticleDTO> articleList = this.articleService.getList();

        return RsData.of("200", "게시글 다건 조회 성공", new ArticlesResponse(articleList));
    }

    //    단건조회
    @GetMapping("/{id}")
    public RsData<ArticleResponse> getArticle(@PathVariable("id") Long id) {
        ArticleDTO  articleDTO = this.articleService.getArticle(id);

        return RsData.of("200", "게시글 단건 조회 성공", new ArticleResponse(articleDTO));
    }

    //    등록
    @PostMapping("")
    public RsData<ArticleCreateResponse> create(@Valid @RequestBody ArticleCreateRequest articleCreateRequest) {
        Article article = this.articleService.write(articleCreateRequest.getSubject(), articleCreateRequest.getContent());
        return RsData.of("200", "등록성공", new ArticleCreateResponse(article));
    }

    //    수정
    @PatchMapping("/{id}")
    public String modify(@PathVariable("id") Long id, @Valid @RequestBody ArticleModifyRequest articleModifyRequest) {

        return "수정완료";
    }

    //    삭제는 단순 삭제로 구현
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {

        return "삭제완료";
    }
}
