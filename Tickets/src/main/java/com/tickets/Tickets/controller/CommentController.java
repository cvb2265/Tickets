package com.tickets.Tickets.controller;

import com.tickets.Tickets.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;


    @RequestMapping("/comment/{planid}")
    public ModelAndView getCommentOfOnePlan(ModelAndView mv, @PathVariable("planid")long planid){
        return mv;
    }
}
