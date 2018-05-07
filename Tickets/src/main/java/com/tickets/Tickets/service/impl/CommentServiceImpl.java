package com.tickets.Tickets.service.impl;

import com.tickets.Tickets.entity.Comment;
import com.tickets.Tickets.entity.PageDto;
import com.tickets.Tickets.mapper.CommentMapper;
import com.tickets.Tickets.service.CommentService;
import com.tickets.Tickets.util.ResultMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;

    @Transactional(readOnly = true)
    @Override
    public List<Comment> getCommentOfOnePlan(long Planid, PageDto pageDto) {
        List<Comment> commentlist = commentMapper.getCommentOfOnePlan(Planid, pageDto.getOffset_row(), pageDto.getPage_size());
        return commentlist;
    }

    @Override
    public ResultMessage addComment(Comment comment) {
        ResultMessage rm = new ResultMessage();
        commentMapper.addComment(comment);
        rm.setResult(true);
        rm.setMessage("addComment调用成功,评论已经被保存");
        return rm;
    }

    @Override
    public ResultMessage updateComment(Comment comment) {
        ResultMessage rm = new ResultMessage();
        commentMapper.updateComment(comment);
        rm.setResult(true);
        rm.setMessage("updateComment调用成功,评论已经被更新");
        return rm;
    }

    @Transactional(readOnly = true)
    @Override
    public Comment getCommentByid(long id) {
        Comment comment =commentMapper.getCommentById(id);
        return comment;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Comment> getNegativeComments(PageDto pageDto) {
        List<Comment> commentList =commentMapper.getNegativeComments(pageDto);
        return commentList;
    }

    @Transactional(readOnly = true)
    @Override
    public List<Comment> getAllComments(PageDto pageDto) {
        List<Comment> commentList =commentMapper.getAllComments(pageDto);
        return commentList;
    }


    @Override
    public ResultMessage deleteComment(Comment comment) {
        ResultMessage rm = new ResultMessage();
        commentMapper.deleteComment(comment);
        rm.setResult(true);
        rm.setMessage("deleteComment调用成功,评论已经被删除");
        return rm;
    }
}
