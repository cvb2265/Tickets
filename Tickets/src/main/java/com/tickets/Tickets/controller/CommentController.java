package com.tickets.Tickets.controller;

import com.tickets.Tickets.entity.Comment;
import com.tickets.Tickets.entity.PageDto;
import com.tickets.Tickets.service.CommentService;
import com.tickets.Tickets.util.ResultMessage;
import com.tickets.Tickets.vo.CommentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Value("${page_size}")
    private int page_size;

    @RequestMapping("/comment/{planid}")
    public ModelAndView getCommentOfOnePlan(ModelAndView mv, @PathVariable("planid") long planid, HttpSession session, Map<String, Object> map) {
        PageDto pageDto = new PageDto((int) commentService.countAllOfOnePlan(planid), 1, 5);
        List<Comment> comments = commentService.getCommentOfOnePlan(planid, pageDto);
        map.put("comments", comments);
        map.put("pageDto", pageDto);
        mv.setViewName("/plan/list");
        return mv;
    }

    @RequestMapping("/commentlist/all/{current_page}")
    public ModelAndView getCommentList(ModelAndView mv,
                                       HttpSession session,
                                       HttpServletRequest request,
                                       Map<String, Object> map,
                                       @PathVariable("current_page") int current_page) {
        //TODO,size=0且currentpage=1未考虑
        PageDto pageDto = new PageDto((int) commentService.countAll(), current_page, page_size);
        List<CommentVo> commentVos = commentService.getAllComments(pageDto);
        if (commentVos.size() == 0) {
            mv.setViewName("redirect:/commenylist/all/" + --current_page);
        }
        map.put("commentVos", commentVos);
        map.put("pageDto", pageDto);
        mv.setViewName("/comment/list");
        return mv;
    }

    @RequestMapping("/commentlist/negative/unpass/{current_page}")
    public ModelAndView getNegativeUnpassCommentList(ModelAndView mv,
                                                     HttpSession session,
                                                     HttpServletRequest request,
                                                     Map<String, Object> map,
                                                     @PathVariable("current_page") int current_page) {
        //TODO,size=0且currentpage=1未考虑
        PageDto pageDto = new PageDto((int) commentService.countNegativeUnpass(), current_page, page_size);
        List<CommentVo> commentVos = commentService.getNegativeUnpassComments(pageDto);
        if (commentVos.size() == 0) {
            mv.setViewName("redirect:/commenylist/negative/unpass/" + --current_page);
        }
        map.put("commentVos", commentVos);
        map.put("pageDto", pageDto);
        mv.setViewName("/comment/negativeunpasslist");
        return mv;
    }

    @RequestMapping("/commentlist/all/unpass/{current_page}")
    public ModelAndView getUnpassCommentList(ModelAndView mv,
                                             HttpSession session,
                                             HttpServletRequest request,
                                             Map<String, Object> map,
                                             @PathVariable("current_page") int current_page) {
        //TODO,size=0且currentpage=1未考虑
        PageDto pageDto = new PageDto((int) commentService.countUnpass(), current_page, page_size);
        List<CommentVo> commentVos = commentService.getUnpassComments(pageDto);
        if (commentVos.size() == 0) {
            mv.setViewName("redirect:/commenylist/all/unpass/" + --current_page);
        }
        map.put("commentVos", commentVos);
        map.put("pageDto", pageDto);
        mv.setViewName("/comment/unpasslist");
        return mv;
    }

    @RequestMapping("comment/view/{comment_id}")
    public ModelAndView commentView(
            ModelAndView mv,
            HttpSession session,
            HttpServletRequest request,
            @PathVariable("comment_id") long comment_id,
            Model model) {
        CommentVo commentVo = commentService.getCommentByid(comment_id);
        model.addAttribute("commentVo", commentVo);
        mv.setViewName("/comment/view");
        return mv;
    }


    @RequestMapping("/reviewComment")
    public ModelAndView reviewComment(ModelAndView mv,
                                      HttpSession session,
                                      HttpServletRequest request,
                                      Comment comment,
                                      Model model) {
        System.out.println(comment.getContent());
        ResultMessage rm = commentService.updateComment(comment);
        model.addAttribute("rm", rm);
        mv.setViewName("/comment/reviewresult");
        return mv;
    }


}
