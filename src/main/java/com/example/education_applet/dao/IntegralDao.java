package com.example.education_applet.dao;

import com.example.education_applet.mapper.IntegralMapper;
import com.example.education_applet.pojo.Integral;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Repository
public class IntegralDao {

    @Autowired
    private IntegralMapper integralMapper;

    public Integer insertIntegral(Integral integral){
        return integralMapper.insert(integral);
    }

    public Integral selectIntegralById(Long id){
        return integralMapper.selectByPrimaryKey(id);
    }

    public List<Integral> selectIntegralByUserId(Long userId){
        Example example = new Example(Integral.class);
        example.createCriteria().andEqualTo("userId",userId);
        return integralMapper.selectByExample(example);
    }

    public List<Integral> selectIntegralByGetWay(String getWay){
        Example example = new Example(Integral.class);
        example.createCriteria().andEqualTo("getIntegralWay",getWay);
        return integralMapper.selectByExample(example);
    }

    public List<Integral> selectIntegralByUserIdAndGetWay(Long userId,String getWay){
        Example example = new Example(Integral.class);
        example.createCriteria().andEqualTo("userId",userId)
                .andEqualTo("getIntegralWay",getWay);
        return integralMapper.selectByExample(example);
    }

    public List<Integral> selectAllIntegral(){
        return integralMapper.selectAll();
    }

    public Integer countIntegralByUserId(Long userId){
        Example example = new Example(Integral.class);
        example.createCriteria().andEqualTo("userId",userId);
        return integralMapper.selectCountByExample(example);
    }

    public Integer countIntegralByGetWay(String getWay){
        Example example = new Example(Integral.class);
        example.createCriteria().andEqualTo("getIntegralWay",getWay);
        return integralMapper.selectCountByExample(example);
    }

    public Integer countIntegralByUserIdAndGetWay(Long userId,String getWay) {
        Example example = new Example(Integral.class);
        example.createCriteria().andEqualTo("userId", userId)
                .andEqualTo("getIntegralWay", getWay);
        return integralMapper.selectCountByExample(example);
    }

    public Integer countAllIntegral(){
        Example example = new Example(Integral.class);
        return integralMapper.selectCountByExample(example);
    }

}
