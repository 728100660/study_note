package com.pxz.dao;

import com.pxz.pojo.Article;

import java.util.List;

public interface ArticleMapper {

    List<Article> getAllArticles();

    Article getArticleInfo(int id);
}
