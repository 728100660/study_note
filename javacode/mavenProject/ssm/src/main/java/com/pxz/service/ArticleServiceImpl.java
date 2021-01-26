package com.pxz.service;

import com.pxz.dao.ArticleMapper;
import com.pxz.pojo.Article;

import java.util.List;

public class ArticleServiceImpl implements ArticleService{

    private ArticleMapper articleMapper;

    public void setArticleMapper(ArticleMapper articleMapper) {
        this.articleMapper = articleMapper;
    }

    @Override
    public List<Article> getAllArticles() {
        return articleMapper.getAllArticles();
    }

    @Override
    public Article getArticleInfo(int id) {
        return articleMapper.getArticleInfo(id);
    }
}
