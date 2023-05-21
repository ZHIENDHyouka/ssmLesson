package com.example.ssmlesson.dao;

import com.example.ssmlesson.pojo.Manager;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface ManagerDAO {

    public Manager selectManager( String ManagerName);

}
