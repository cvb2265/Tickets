package com.tickets.Tickets.mapper;

import com.tickets.Tickets.entity.Level;
import com.tickets.Tickets.entity.PageDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
//cf
@Mapper
public interface LevelMapper {
    Level getLevelDetails(int id);
    Level findByLevel_num(Integer level_num);
    void addLevel(Level level);
    boolean delLevel(int id);
    void updateLevel(Level level);

    Integer count();
    List<Level> ListLevels(PageDto pageDto);
}
