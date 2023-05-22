package com.example.ssmlesson.dao;

import com.example.ssmlesson.pojo.Kq;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface KqDAO {
    public int insertKq(Kq kq);
    public int deleteKq(int kqId);
    public Kq selectKq(int kqId);
    public List<Kq> selectKqList(@Param("s")  int start , @Param("l") int limit);
    public int selectCount();


}
