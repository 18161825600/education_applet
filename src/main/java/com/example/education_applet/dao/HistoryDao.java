package com.example.education_applet.dao;

import com.example.education_applet.mapper.HistoryMapper;
import com.example.education_applet.pojo.History;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Repository
public class HistoryDao {

    @Autowired
    private HistoryMapper historyMapper;

    public Integer insertHistory(History history){
        return historyMapper.insert(history);
    }

    public Integer deleteHistory(List<Long> ids){
        Example example = new Example(History.class);
        example.createCriteria().andIn("id",ids);
        return historyMapper.deleteByExample(example);
    }

    public History selectHistoryById(Long id){
        return historyMapper.selectByPrimaryKey(id);
    }

    public List<History> selectHistoryByUserId(Long userId){
        Example example = new Example(History.class);
        example.createCriteria().andEqualTo("userId",userId);
        return historyMapper.selectByExample(example);
    }

    public List<History> selectHistoryByVideoId(Long videoId){
        Example example = new Example(History.class);
        example.createCriteria().andEqualTo("videoId",videoId);
        return historyMapper.selectByExample(example);
    }

    public List<History> selectAllHistory(){
        return historyMapper.selectAll();
    }

    public Integer countHistoryByUserId(Long userId) {
        Example example = new Example(History.class);
        example.createCriteria().andEqualTo("userId", userId);
        return historyMapper.selectCountByExample(example);
    }

    public Integer countHistoryByVideoId(Long videoId) {
        Example example = new Example(History.class);
        example.createCriteria().andEqualTo("videoId", videoId);
        return historyMapper.selectCountByExample(example);
    }

    public Integer countAllHistory(){
        Example example = new Example(History.class);
        return historyMapper.selectCountByExample(example);
    }
}
