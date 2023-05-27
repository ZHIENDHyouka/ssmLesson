package com.example.ssmlesson.dao;

import com.example.ssmlesson.pojo.Title;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface TitleDAO {
    public int insertTitle(Title title);
    public int deleteTitle(int titleId);
    public int  updateTitleRemark(@Param("i")int titleId, @Param("r") String titleRemark);
    public int updateTitleMoney(@Param("i")int titleId,@Param("m")float titleMoney);
    public Title selectTitle(int titleId);
    public List<Title> selectTitleList(@Param("s")  int start , @Param("l") int limit);
    public int selectCount();
    List<Title> queryAllTitleInfo();
    int updateTitleMoneyAndRemark(@Param("title") Title title);
    @MapKey("t_id")
    List<Map<String,Object>> queryTitleIdName();

}
