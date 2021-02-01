package com.pxz.dao;

import com.pxz.pojo.Article;

import java.util.List;
import java.util.Map;

public interface ArticleMapper {

    List<Article> getArticleInfo(Map<String,Object> map);
}
