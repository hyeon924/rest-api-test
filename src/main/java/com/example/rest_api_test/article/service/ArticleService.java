package com.example.rest_api_test.article.service;

import com.example.rest_api_test.article.dto.ArticleDTO;
import com.example.rest_api_test.article.entity.Article;
import com.example.rest_api_test.article.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ArticleService {    private final ArticleRepository articleRepository;
    // 다건 게시글 조회
    public List<ArticleDTO> getList() {
        List<Article> articleList = this.articleRepository.findAll(); // 전체 조회
        List<ArticleDTO> articleDTOList = articleList.stream()
                .map(article -> new ArticleDTO(article))
                .collect(Collectors.toList());
        return articleDTOList;
    }
    // 단건 게시글 조회
    public ArticleDTO getArticle(Long id) {
        Optional<Article> optionalArticle = this.articleRepository.findById(id); // 아이디 조회
        return optionalArticle.map(article -> new ArticleDTO(article)).orElse(null);
    }
    }