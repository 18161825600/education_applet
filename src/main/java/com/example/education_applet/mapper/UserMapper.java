package com.example.education_applet.mapper;

import com.example.education_applet.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends CommonMapper<User> {
}