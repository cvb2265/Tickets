package com.tickets.Tickets.mapper;

import com.tickets.Tickets.entity.Comment;
import com.tickets.Tickets.entity.PageDto;
import com.tickets.Tickets.vo.CommentVo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;
//cf
@Mapper
public interface CommentMapper {

    @Select(value = "SELECT * FROM comment WHERE planid = #{planid} AND userid = #{userid}")
    public Comment findComment(@Param("planid")String planid, @Param("userid")String userid);

    CommentVo getCommentById(long id);

    void addComment(Comment commment);

    List<Comment> getCommentOfOnePlan(@Param("planid")long planid,@Param("offset_row") int offset_row,@Param("page_size")int  page_size);
    List<CommentVo> getAllComments(PageDto pageDto);
   // List<CommentVo> getNegativeComments(PageDto pageDto);
    void updateComment(Comment comment);
    void deleteComment(Comment comment);

    Integer countAllOfOnePlan(long planid);

    Integer countAll();

    Integer countNegativeUnpass();

    Integer countUnpass();

    List<CommentVo> getNegativeUnpassComments(PageDto pageDto);

    List<CommentVo> getUnpassComments(PageDto pageDto);
}
