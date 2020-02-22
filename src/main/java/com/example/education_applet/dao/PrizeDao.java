package com.example.education_applet.dao;

import com.example.education_applet.mapper.PrizeMapper;
import com.example.education_applet.pojo.Prize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Repository
public class PrizeDao {

    @Autowired
    private PrizeMapper prizeMapper;

    public Integer insertPrize(Prize prize){
        return prizeMapper.insert(prize);
    }

    public Integer deletePrize(List<Long> ids){
        Example example = new Example(Prize.class);
        example.createCriteria().andIn("id",ids);
        return prizeMapper.deleteByExample(example);
    }

    public Integer updatePrize(Prize prize){
        return prizeMapper.updateByPrimaryKeySelective(prize);
    }

    public Prize selectPrizeById(Long id){
        return prizeMapper.selectByPrimaryKey(id);
    }

    public List<Prize> selectAllPrize(){
        return prizeMapper.selectAll();
    }

    public Integer countAllPrize(){
        Example example = new Example(Prize.class);
        return prizeMapper.selectCountByExample(example);
    }

}
