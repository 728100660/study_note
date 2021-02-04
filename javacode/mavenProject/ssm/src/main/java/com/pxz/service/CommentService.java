package com.pxz.service;

import com.pxz.pojo.Comment;

import java.util.List;

public interface CommentService {
    public Comment getComment(int articleId);

    List<Comment> getSubComment(int commentId);

    int doComment(Comment comment);

    int deleteComment(int commentId);
}
