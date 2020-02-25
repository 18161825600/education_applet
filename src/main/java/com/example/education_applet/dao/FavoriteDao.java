package com.example.education_applet.dao;

import com.example.education_applet.mapper.FavoriteMapper;
import com.example.education_applet.pojo.Favorite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Repository
public class FavoriteDao {

    @Autowired
    private FavoriteMapper favoriteMapper;

    public Integer insertFavorite(Favorite favorite){
        return favoriteMapper.insert(favorite);
    }

    public Integer deleteFavorite(List<Long> ids){
        Example example = new Example(Favorite.class);
        example.createCriteria().andIn("id",ids);
        return favoriteMapper.deleteByExample(example);
    }

    public Favorite selectFavoriteById(Long id){
        return favoriteMapper.selectByPrimaryKey(id);
    }

    public Favorite selectFavoriteByUserIdAndVideoId(Long userId,Long videoId){
        Example example = new Example(Favorite.class);
        example.createCriteria().andEqualTo("userId",userId)
                .andEqualTo("videoId",videoId);
        return favoriteMapper.selectOneByExample(example);
    }

    public List<Favorite> selectFavoriteByUserId(Long userId){
        Example example = new Example(Favorite.class);
        example.createCriteria().andEqualTo("userId",userId);
        return favoriteMapper.selectByExample(example);
    }

    public List<Favorite> selectFavoriteByVideoId(Long videoId){
        Example example = new Example(Favorite.class);
        example.createCriteria().andEqualTo("videoId",videoId);
        return favoriteMapper.selectByExample(example);
    }

    public List<Favorite> selectAllFavorite(){
        return favoriteMapper.selectAll();
    }

    public Integer countFavoriteByUserId(Long userId) {
        Example example = new Example(Favorite.class);
        example.createCriteria().andEqualTo("userId", userId);
        return favoriteMapper.selectCountByExample(example);
    }

    public Integer countFavoriteByVideoId(Long videoId) {
        Example example = new Example(Favorite.class);
        example.createCriteria().andEqualTo("videoId", videoId);
        return favoriteMapper.selectCountByExample(example);
    }

    public Integer countAllFavorite(){
        Example example = new Example(Favorite.class);
        return favoriteMapper.selectCountByExample(example);
    }
}
