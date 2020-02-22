package com.example.education_applet.dao;

import com.example.education_applet.mapper.GetPrizeMapper;
import com.example.education_applet.pojo.GetPrize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Repository
public class GetPrizeDao {

    @Autowired
    private GetPrizeMapper getPrizeMapper;

    public Integer insertGetPrize(GetPrize getPrize){
        return getPrizeMapper.insert(getPrize);
    }

    public Integer deleteGetPrize(List<Long> ids){
        Example example = new Example(GetPrize.class);
        example.createCriteria().andIn("id",ids);
        return getPrizeMapper.deleteByExample(example);
    }

    public GetPrize selectGetPrizeById(Long id){
        return getPrizeMapper.selectByPrimaryKey(id);
    }

    public List<GetPrize> selectGetPrizeByUserId(Long userId){
        Example example = new Example(GetPrize.class);
        example.createCriteria().andEqualTo("userId",userId);
        return getPrizeMapper.selectByExample(example);
    }

    public List<GetPrize> selectGetPrizeByPrizeId(Long prizeId){
        Example example = new Example(GetPrize.class);
        example.createCriteria().andEqualTo("prizeId",prizeId);
        return getPrizeMapper.selectByExample(example);
    }

    public List<GetPrize> selectAllGetPrize(){
        return getPrizeMapper.selectAll();
    }

    public Integer countGetPrizeByUserId(Long userId) {
        Example example = new Example(GetPrize.class);
        example.createCriteria().andEqualTo("userId", userId);
        return getPrizeMapper.selectCountByExample(example);
    }

    public Integer countGetPrizeByPrizeId(Long prizeId) {
        Example example = new Example(GetPrize.class);
        example.createCriteria().andEqualTo("prizeId", prizeId);
        return getPrizeMapper.selectCountByExample(example);
    }

    public Integer countAllGetPrize(){
        Example example = new Example(GetPrize.class);
        return getPrizeMapper.selectCountByExample(example);
    }
}
