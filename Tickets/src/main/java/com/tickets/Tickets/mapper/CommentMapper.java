package com.tickets.Tickets.mapper;

import com.tickets.Tickets.entity.Comment;
import com.tickets.Tickets.entity.PageDto;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
//cf
@Mapper
public interface CommentMapper {

    @Select(value = "SELECT * FROM comment WHERE planid = #{planid} AND userid = #{userid}")
    public Comment findComment(@Param("planid")String planid, @Param("userid")String userid);

    Comment getCommentById(long id);

    void addComment(Comment commment);

    List<Comment> getCommentOfOnePlan(@Param("planid")long planid,@Param("offset_row") int offset_row,@Param("page_size")int  page_size);
    List<Comment> getAllComments(PageDto pageDto);
    List<Comment> getNegativeComments(PageDto pageDto);
    void updateComment(Comment comment);
    void deleteComment(Comment comment);
}
