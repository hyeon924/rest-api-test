package com.example.rest_api_test.article.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/articles")
public class ApiV1ArticleController {

//    다건조회
    @GetMapping("")
    public String list() {
        return "";
    }

    //    단건조회
    @GetMapping("/{id}")
    public String getArticle() {
        return "";
    }

    //    등록
    @PostMapping("")
    public String create() {
        return "";
    }

    //    수정
    @PatchMapping("/{id}")
    public String modify() {
        return "";
    }

    //    삭제
    @DeleteMapping("/{id}")
    public String delete() {
        return "";
    }
}
