package com.pxz.service;

import com.pxz.dao.ArticleMapper;
import com.pxz.pojo.Article;

import java.util.List;
import java.util.Map;

public class ArticleServiceImpl implements ArticleService{

    private ArticleMapper articleMapper;

    public void setArticleMapper(ArticleMapper articleMapper) {
        this.articleMapper = articleMapper;
    }

    @Override
    public List<Article> getArticleInfo(Map<String,Object> map) {
        return articleMapper.getArticleInfo(map);
    }

    @Override
    public int createArticle(Article article) {
        return articleMapper.createArticle(article);
    }

    @Override
    public int updateArticle(Article article) {
        return articleMapper.updateArticle(article);
    }

    @Override
    public int deleteArticle(int articleId) {
        return articleMapper.deleteArticle(articleId);
    }
}
