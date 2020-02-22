package com.example.education_applet.dao;

import com.example.education_applet.mapper.UserMapper;
import com.example.education_applet.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Repository
public class UserDao {

    @Autowired
    private UserMapper userMapper;

    public Integer insertUser(User user){
        return userMapper.insert(user);
    }

    public Integer updateUser(User user){
        return userMapper.updateByPrimaryKeySelective(user);
    }

    public User selectUserById(Long id){
        return userMapper.selectByPrimaryKey(id);
    }

    public User selectUserByOpenId(String openId){
        Example example = new Example(User.class);
        example.createCriteria().andEqualTo("openId",openId);
        return userMapper.selectOneByExample(example);
    }

    public List<User> selectAllUser(){
        return userMapper.selectAll();
    }

    public Integer countAllUser(){
        Example example = new Example(User.class);
        return userMapper.selectCountByExample(example);
    }
}
