package com.tickets.Tickets.mapper;

import com.tickets.Tickets.entity.Level;
import org.apache.ibatis.annotations.Mapper;
//cf
@Mapper
public interface LevelMapper {
    Level getLevelDetails(int id);
    void addLevel(Level level);
    boolean delLevel(int id);
    void update(Level level);
}
