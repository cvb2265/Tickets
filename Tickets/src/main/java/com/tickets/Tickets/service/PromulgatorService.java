package com.tickets.Tickets.service;

import com.tickets.Tickets.entity.*;

import java.util.ArrayList;
import java.util.List;

public interface PromulgatorService {
    public boolean login(String email,String password );
    //往期音乐会清单
    public ArrayList<Plan> allPlan(int id);
    //查看一场音乐会详细内容
    public Plan showdetail(int planid);
    //制定音乐会策划
    public boolean createPlan(Plan plan);
    //设置场馆座位信息
    public boolean setseatprice(Venue venue);
    //制定周边产品策划
    public boolean createGoodsPlan(ArrayList<Goods> allgoods);
    //上传策划文档
    public void uploadfile(String filename);
    //修改未通过的音乐会信息
    public boolean updatePlan(Plan plan);



    //Cf
    public void addPro(Promulgator promulgator);

    public Promulgator getPromulgatorDetailById(long promulgatorId);

    public void updatePro(Promulgator promulgator);

    public void delPro(long promulgatorId);

    public int count();

    public List<Promulgator> ListPros(PageDto pageDto);

    public Promulgator find(String email, String password);
}
