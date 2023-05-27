package com.example.ssmlesson.dao;

import com.example.ssmlesson.pojo.Kq;
import com.example.ssmlesson.pojo.Salary;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface SalaryDAO {
    public int insertS(Salary salary);
    public int deleteS(int salaryId);
    public Salary selectS(int salaryId);
    public List<Salary> selectSList(@Param("s")  int start , @Param("l") int limit);
    public int selectCount();
    @MapKey("s_id")
    List<Map<String,Object>> queryAllSalaryInfo();

}
