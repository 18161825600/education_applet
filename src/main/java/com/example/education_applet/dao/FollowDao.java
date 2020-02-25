package com.example.education_applet.dao;

import com.example.education_applet.mapper.FollowMapper;
import com.example.education_applet.pojo.Follow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;


@Repository
public class FollowDao {

    @Autowired
    private FollowMapper followMapper;

    public Integer insertFollow(Follow follow){
        return followMapper.insert(follow);
    }

    public Integer deleteFollow(List<Long> ids){
        Example example = new Example(Follow.class);
        example.createCriteria().andIn("id",ids);
        return followMapper.deleteByExample(example);
    }

    public Follow selectFollowById(Long id){
        return followMapper.selectByPrimaryKey(id);
    }

    public Follow selectFollowByUserIdAndRoomId(Long userId,Long roomId){
        Example example = new Example(Follow.class);
        example.createCriteria().andEqualTo("userId",userId)
                .andEqualTo("roomId",roomId);
        return followMapper.selectOneByExample(example);
    }

    public List<Follow> selectFollowByUserId(Long userId){
        Example example = new Example(Follow.class);
        example.createCriteria().andEqualTo("userId",userId);
        return followMapper.selectByExample(example);
    }

    public List<Follow> selectFollowByRoomId(Long roomId){
        Example example = new Example(Follow.class);
        example.createCriteria().andEqualTo("roomId",roomId);
        return followMapper.selectByExample(example);
    }

    public List<Follow> selectAllFollow(){
        return followMapper.selectAll();
    }

    public Integer countFollowByUserId(Long userId) {
        Example example = new Example(Follow.class);
        example.createCriteria().andEqualTo("userId", userId);
        return followMapper.selectCountByExample(example);
    }

    public Integer countFollowByRoomId(Long roomId) {
        Example example = new Example(Follow.class);
        example.createCriteria().andEqualTo("roomId", roomId);
        return followMapper.selectCountByExample(example);
    }

    public Integer countAllFollow(){
        Example example = new Example(Follow.class);
        return followMapper.selectCountByExample(example);
    }
}
