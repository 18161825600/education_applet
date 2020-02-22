package com.example.education_applet.dao;

import com.example.education_applet.mapper.VideoMapper;
import com.example.education_applet.pojo.Video;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Repository
public class VideoDao {

    @Autowired
    private VideoMapper videoMapper;

    public Integer insertVideo(Video video){
        return videoMapper.insert(video);
    }

    public Integer deleteVideo(List<Long> ids){
        Example example = new Example(Video.class);
        example.createCriteria().andIn("id",ids);
        return videoMapper.deleteByExample(example);
    }

    public Integer updateVideo(Video video){
        return videoMapper.updateByPrimaryKeySelective(video);
    }

    public Video selectVideoById(Long id){
        return videoMapper.selectByPrimaryKey(id);
    }

    public List<Video> selectVideoByName(String videoName){
        Example example = new Example(Video.class);
        example.createCriteria().andLike("videoName",videoName);
        return videoMapper.selectByExample(example);
    }

    public List<Video> selectVideoByType(String videoType){
        Example example = new Example(Video.class);
        example.createCriteria().andEqualTo("videoType",videoType);
        return videoMapper.selectByExample(example);
    }

    public List<Video> selectVideoByVip(short isVipVideo){
        Example example = new Example(Video.class);
        example.createCriteria().andEqualTo("isVipVideo",isVipVideo);
        return videoMapper.selectByExample(example);
    }

    public List<Video> selectAllVideo(){
        return videoMapper.selectAll();
    }

    public Integer countVideoByName(String videoName){
        Example example = new Example(Video.class);
        example.createCriteria().andLike("videoName",videoName);
        return videoMapper.selectCountByExample(example);
    }

    public Integer countVideoByType(String videoType){
        Example example = new Example(Video.class);
        example.createCriteria().andEqualTo("videoType",videoType);
        return videoMapper.selectCountByExample(example);
    }

    public Integer countAllVideo(){
        Example example = new Example(Video.class);
        return videoMapper.selectCountByExample(example);
    }

    public Integer countVideoByVip(short isVipVideo){
        Example example = new Example(Video.class);
        example.createCriteria().andEqualTo("isVipVideo",isVipVideo);
        return videoMapper.selectCountByExample(example);
    }
}
