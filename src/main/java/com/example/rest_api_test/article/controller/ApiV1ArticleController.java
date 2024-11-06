package com.example.rest_api_test.article.controller;

import com.example.rest_api_test.article.dto.ArticleDTO;
import com.example.rest_api_test.article.entity.Article;
import com.example.rest_api_test.article.request.ArticleCreateRequest;
import com.example.rest_api_test.article.request.ArticleModifyRequest;
import com.example.rest_api_test.article.response.ArticleResponse;
import com.example.rest_api_test.article.response.ArticlesResponse;
import com.example.rest_api_test.article.service.ArticleService;
import com.example.rest_api_test.global.RsData.RsData;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/articles")
public class ApiV1ArticleController {

    private final ArticleService articleService;

//    다건조회
    @GetMapping("")
    public RsData<ArticlesResponse> list() {
        List<ArticleDTO> articleList = new ArrayList<>();
        Article article1 = new Article("title01", "content01");
        articleList.add(new ArticleDTO(article1));
        Article article2 = new Article("title02", "content02");
        articleList.add(new ArticleDTO(article2));
        Article article3 = new Article("title03", "content03");
        articleList.add(new ArticleDTO(article3));
        return RsData.of("200", "게시글 다건 조회 성공", new ArticlesResponse(articleList));
    }

    //    단건조회
    @GetMapping("/{id}")
    public RsData<ArticleResponse> getArticle(@PathVariable("id") Long id) {
        Article article = new Article("title", "content");
        ArticleDTO articleDTO = new ArticleDTO(article);
        return RsData.of("200", "게시글 단건 조회 성공", new ArticleResponse(articleDTO));
    }

    //    등록
    @PostMapping("")
    public String create(@Valid @RequestBody ArticleCreateRequest articleCreateRequest) {
        System.out.println(articleCreateRequest.getSubject());
        System.out.println(articleCreateRequest.getContent());

        return "등록완료";
    }

    //    수정
    @PatchMapping("/{id}")
    public String modify(@PathVariable("id") Long id, @Valid @RequestBody ArticleModifyRequest articleModifyRequest) {
        System.out.println(id);
        System.out.println(articleModifyRequest.getSubject());
        System.out.println(articleModifyRequest.getContent());
        return "수정완료";
    }

    //    삭제
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        System.out.println(id);
        return "삭제완료";
    }
}
