package com.pxz.service;

import com.pxz.dao.CommentMapper;
import com.pxz.pojo.Comment;

import java.util.List;

public class CommentServiceImpl implements CommentService {
    CommentMapper commentMapper;

    @Override
    public Comment getComment(int articleId) {
        return commentMapper.getComment(articleId);
    }

    @Override
    public List<Comment> getSubComment(int commentId) {
        return commentMapper.getSubComment(commentId);
    }

    @Override
    public int doComment(Comment comment) {
        return commentMapper.doComment(comment);
    }

    @Override
    public int deleteComment(int commentId) {
        return commentMapper.deleteComment(commentId);
    }

    public void setCommentMapper(CommentMapper commentMapper) {
        this.commentMapper = commentMapper;
    }
}
