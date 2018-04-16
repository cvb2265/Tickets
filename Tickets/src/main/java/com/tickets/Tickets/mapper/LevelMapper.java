package com.tickets.Tickets.mapper;

import com.tickets.Tickets.entity.Level;
import com.tickets.Tickets.entity.PageDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface LevelMapper {
    Level getLevelDetails(int id);
    //cf
    @Mapper
    void addLevel(Level level);
    boolean delLevel(int id);
    void updateLevel(Level level);

    List<Level> ListLevels(PageDto pageDto);
}
