package com.tickets.Tickets.service;

import com.tickets.Tickets.entity.Comment;
import com.tickets.Tickets.entity.PageDto;
import com.tickets.Tickets.util.ResultMessage;

import java.util.List;


public interface CommentService {
        public List<Comment> getCommentOfOnePlan(long Planid, PageDto pageDto);
        public ResultMessage addComment(Comment comment);

        public ResultMessage updateComment(Comment comment);
        public Comment getCommentByid(long id);

        public List<Comment> getNegativeComments(PageDto pageDto);
        public List<Comment> getAllComments(PageDto pageDto);
        public ResultMessage deleteComment(Comment comment);
        public int countAllOfOnePlan(long planid);
}
