package com.example.ssmlesson.dao;

import com.example.ssmlesson.pojo.Manager;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Mapper
public interface ManagerDAO {

     Manager selectManager(@Param("username") String username);
     Manager queryManagerRealName(@Param("id")int id);

}
