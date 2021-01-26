package com.pxz.service;

import com.pxz.pojo.Article;

import java.util.List;

public interface ArticleService {
    List<Article> getAllArticles();

    Article getArticleInfo(int id);
}
