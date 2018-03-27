package com.tickets.Tickets.controller;

import com.tickets.Tickets.entity.Level;
import com.tickets.Tickets.mapper.LevelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//cf
@Controller
public class LevelController {
    @Autowired
    LevelMapper lm;
    Level newl =new Level(1,1,50,0.99);
    @RequestMapping("/level")
    public String levelIndex(){
        lm.delLevel(newl.getId());
        return "/level/index";
    }
}
