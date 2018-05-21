package com.tickets.Tickets.controller;

import com.tickets.Tickets.entity.Comment;
import com.tickets.Tickets.entity.PageDto;
import com.tickets.Tickets.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;


    @RequestMapping("/comment/{planid}")
    public ModelAndView getCommentOfOnePlan(ModelAndView mv, @PathVariable("planid")long planid, HttpSession session, Map<String,Object> map){
        PageDto pageDto = new PageDto((int) commentService.countAllOfOnePlan(planid), 1, 5);
        List<Comment> comments =commentService.getCommentOfOnePlan(planid,pageDto);
        map.put("comments",comments);
        map.put("pageDto",pageDto);
        mv.setViewName("/plan/list");
        return mv;
    }
}
