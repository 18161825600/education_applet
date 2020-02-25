package com.example.education_applet.dao;

import com.example.education_applet.mapper.RoomMapper;
import com.example.education_applet.pojo.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Repository
public class RoomDao {

    @Autowired
    private RoomMapper roomMapper;

    public Integer insertRoom(Room room){
        return roomMapper.insert(room);
    }

    public Integer updateRoom(Room room){
        return roomMapper.updateByPrimaryKeySelective(room);
    }

    public Room selectRoomById(Long id){
        return roomMapper.selectByPrimaryKey(id);
    }

    public List<Room> selectRoomByName(String roomName){
        Example example = new Example(Room.class);
        example.createCriteria().andLike("roomName","%"+roomName+"%");
        return roomMapper.selectByExample(example);
    }

    public List<Room> selectRoomByState(Short roomState){
        Example example = new Example(Room.class);
        example.createCriteria().andEqualTo("roomState",roomState);
        return roomMapper.selectByExample(example);
    }

    public List<Room> selectAllRoom(){
        return roomMapper.selectAll();
    }

    public Integer countRoomByName(String roomName) {
        Example example = new Example(Room.class);
        example.createCriteria().andLike("roomName", "%" + roomName + "%");
        return roomMapper.selectCountByExample(example);
    }

    public Integer countRoomByState(Short roomState) {
        Example example = new Example(Room.class);
        example.createCriteria().andEqualTo("roomState", roomState);
        return roomMapper.selectCountByExample(example);
    }

    public Integer countAllRoom(){
        Example example = new Example(Room.class);
        return roomMapper.selectCountByExample(example);
    }
}
