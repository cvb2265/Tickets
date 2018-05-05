package com.tickets.Tickets.mapper;

import com.tickets.Tickets.entity.Level;
import com.tickets.Tickets.entity.PageDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
//cf
@Mapper
public interface LevelMapper {
    Level getLevelDetails(Long id);
    Level findByLevel_num(Integer level_num);
    List<Level> findAll();
    void addLevel(Level level);
    boolean delLevel(Long id);
    void updateLevel(Level level);

    Integer count();
    List<Level> ListLevels(PageDto pageDto);
}
