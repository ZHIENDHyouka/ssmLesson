package com.example.ssmlesson.dao;

import com.example.ssmlesson.pojo.Kq;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.io.StringReader;
import java.util.List;
import java.util.Map;

@Mapper
public interface KqDAO {
    public int insertKq(Kq kq);
    public int deleteKq(int kqId);
    public Kq selectKq(int kqId);
    public List<Kq> selectKqList(@Param("s")  int start , @Param("l") int limit);
    public int selectCount();
    @MapKey("k_id")
    List<Map<String,Object>> queryAllKqInfo();
    Kq queryEmpKq(@Param("kq")Kq kq);
    int updateKqAllInt(@Param("id")int id);


}
