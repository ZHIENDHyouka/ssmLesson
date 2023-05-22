package com.example.ssmlesson.dao;

import com.example.ssmlesson.pojo.Kq;
import com.example.ssmlesson.pojo.Salary;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SalaryDAO {
    public int insertS(Salary salary);
    public int deleteS(int salaryId);
    public Salary selectS(int salaryId);
    public List<Salary> selectSList(@Param("s")  int start , @Param("l") int limit);
    public int selectCount();

}
