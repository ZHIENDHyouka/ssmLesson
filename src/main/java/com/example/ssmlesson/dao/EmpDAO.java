package com.example.ssmlesson.dao;

import com.example.ssmlesson.pojo.Dep;
import com.example.ssmlesson.pojo.Emp;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface EmpDAO {
    public int insertEmp(Emp emp);
    public int deleteEmp(int depId);
    public int updatePost(@Param("e")int empId, @Param("p") int postId);
    public int updateTitle(@Param("e")int empId, @Param("t") int titleId);
    public Emp selectEmp(int empId);
    public List<Emp> selectEmpList(@Param("s")  int start , @Param("l") int limit);
    public int selectCount();
    @MapKey("id")
    List<Map<String,Object>> queryAllEmpInfo();


}
