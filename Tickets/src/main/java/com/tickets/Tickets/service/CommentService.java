package com.tickets.Tickets.service;

import com.tickets.Tickets.entity.Comment;
import com.tickets.Tickets.entity.PageDto;


public interface CommentService {
        public <list>Comment getCommentOfOnePlan(long Planid, PageDto pageDto);
        public  void addComment(Comment comment);

        public void updateComment(Comment comment);
        public Comment getCommentByid(long id);

        public <list>Comment getNegativeComments(PageDto pageDto);
        public <list>Comment getAllComments(PageDto pageDto);
        public void deleteComment(Comment comment);
}
