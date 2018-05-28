package com.tickets.Tickets.service;

import com.tickets.Tickets.entity.Comment;
import com.tickets.Tickets.entity.PageDto;
import com.tickets.Tickets.util.ResultMessage;
import com.tickets.Tickets.vo.CommentVo;

import java.util.List;


public interface CommentService {
    public List<Comment> getCommentOfOnePlan(long Planid, PageDto pageDto);

    public ResultMessage addComment(Comment comment);

    public ResultMessage updateComment(Comment comment);

    public CommentVo getCommentByid(long id);

//    public List<CommentVo> getNegativeComments(PageDto pageDto);

    public List<CommentVo> getAllComments(PageDto pageDto);

    public ResultMessage deleteComment(Comment comment);

    public Integer countAllOfOnePlan(long planid);

    public Integer countAll();

    public Integer countNegativeUnpass();

    public List<CommentVo> getNegativeUnpassComments(PageDto pageDto);

    public Integer countUnpass();

    public List<CommentVo> getUnpassComments(PageDto pageDto);
}
