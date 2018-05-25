package com.tickets.Tickets.controller;

import com.tickets.Tickets.entity.Level;
import com.tickets.Tickets.entity.PageDto;
import com.tickets.Tickets.mapper.LevelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

//cf
@Controller
public class LevelController {
    @Autowired
    LevelMapper lm;
    @Value("${page_size}")
    private int page_size;

    @RequestMapping("/level/{current_page}")
    public String levelList(@PathVariable("current_page") int current_page, Map<String, Object> map, HttpSession httpSession) {
        //int a =lm.count();
        //System.out.println(a);
        PageDto pageDto = new PageDto((int) lm.count(), current_page, page_size);
        //System.out.println(pageDto);
        List<Level> levels = lm.ListLevels(pageDto);
        if (levels.size() == 0) {
            return "redirect:/level/" + --current_page;
        }
        map.put("levels", levels);
        map.put("pageDto", pageDto);

        return "/level/list";
    }

    @RequestMapping("/level/add")
    public String addLevel(Level level, HttpSession httpSession) {
        System.out.println(level);
        lm.addLevel(level);
        return "redirect:/level/1";
    }

    @RequestMapping("/level/{current_page}/{level_id}")
    public String detailLevel(@PathVariable("current_page") int current_page, @PathVariable("level_id") long level_id, Model model) {
        Level level = lm.getLevelDetails(level_id);
        model.addAttribute("level", level);
        model.addAttribute("current_page", current_page);
        return "level/edit";
    }

    @RequestMapping("/level/{current_page}/{level_id}/delete")
    public String deleteLevel(@PathVariable("current_page") int current_page, @PathVariable("level_id") long level_id) {
        lm.delLevel(level_id);
        return "redirect:/level/" + current_page;
    }

    @RequestMapping(path= {"/level/update/{current_page}"} , method = {RequestMethod.POST})
    public String edit (@PathVariable("current_page") int current_page , Level level) {
       // System.out.println(level.getDiscount()+"++++++++++++++++++++++++++++++++++++++++++++++++++");
        lm.updateLevel(level);
        return "redirect:/level/" + current_page ;
    }

    @RequestMapping("/level/addpage")
    public String toAddPage(){
        return "/level/add";
    }
}
