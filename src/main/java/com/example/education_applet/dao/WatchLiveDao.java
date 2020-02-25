package com.example.education_applet.dao;

import com.example.education_applet.mapper.WatchLiveMapper;
import com.example.education_applet.pojo.WatchLive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Repository
public class WatchLiveDao {

    @Autowired
    private WatchLiveMapper watchLiveMapper;

    public Integer insertWatchLive(WatchLive watchLive){
        return watchLiveMapper.insert(watchLive);
    }

    public Integer deleteWatchLive(List<Long> ids){
        Example example = new Example(WatchLive.class);
        example.createCriteria().andIn("id",ids);
        return watchLiveMapper.deleteByExample(example);
    }

    public Integer updateWatchLive(WatchLive watchLive){
        return watchLiveMapper.updateByPrimaryKeySelective(watchLive);
    }

    public WatchLive selectWatchLiveById(Long id){
        return watchLiveMapper.selectByPrimaryKey(id);
    }

    public WatchLive selectWatchLiveByUserIdAndRoomId(Long userId,Long roomId){
        Example example = new Example(WatchLive.class);
        example.createCriteria().andEqualTo("userId",userId)
                .andEqualTo("roomId",roomId);
        return watchLiveMapper.selectOneByExample(example);
    }

    public List<WatchLive> selectWatchLiveByUserId(Long userId){
        Example example = new Example(WatchLive.class);
        example.createCriteria().andEqualTo("userId",userId);
        return watchLiveMapper.selectByExample(example);
    }

    public List<WatchLive> selectWatchLiveByRoomId(Long roomId){
        Example example = new Example(WatchLive.class);
        example.createCriteria().andEqualTo("roomId",roomId);
        return watchLiveMapper.selectByExample(example);
    }

    public List<WatchLive> selectAllWatchLive(){
        return watchLiveMapper.selectAll();
    }

    public Integer countWatchLiveByUserId(Long userId) {
        Example example = new Example(WatchLive.class);
        example.createCriteria().andEqualTo("userId", userId);
        return watchLiveMapper.selectCountByExample(example);
    }

    public Integer countWatchLiveByRoomId(Long roomId) {
        Example example = new Example(WatchLive.class);
        example.createCriteria().andEqualTo("roomId", roomId);
        return watchLiveMapper.selectCountByExample(example);
    }

    public Integer countAllWatchLive(){
        Example example = new Example(WatchLive.class);
        return watchLiveMapper.selectCountByExample(example);
    }
}
