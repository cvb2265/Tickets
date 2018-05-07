package com.tickets.Tickets.service.impl;

import com.tickets.Tickets.entity.Comment;
import com.tickets.Tickets.entity.PageDto;
import com.tickets.Tickets.service.CommentService;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {
    @Override
    public <list> Comment getCommentOfOnePlan(long Planid, PageDto pageDto) {
        return null;
    }

    @Override
    public void addComment(Comment comment) {

    }

    @Override
    public void updateComment(Comment comment) {

    }

    @Override
    public Comment getCommentByid(long id) {
        return null;
    }

    @Override
    public <list> Comment getNegativeComments(PageDto pageDto) {
        return null;
    }

    @Override
    public <list> Comment getAllComments(PageDto pageDto) {
        return null;
    }

    @Override
    public void deleteComment(Comment comment) {

    }
}
