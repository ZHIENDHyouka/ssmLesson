package com.example.ssmlesson.dao;

import com.example.ssmlesson.pojo.Dep;
import com.example.ssmlesson.pojo.ResultVO;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface DepDAO {
    public int insertDep(Dep dep);
    public int deleteDep(int depId);
    public int  updateDepRemark(@Param("i")int depId, @Param("r") String depRemark);
    public int updateDepMoney(@Param("i")int depId,@Param("m")float depMoney);
    public Dep selectDep(int depId);
    public List<Dep> selectDepList(@Param("s")  int start , @Param("l") int limit);
    public int selectCount();
    List<Dep> queryAllDepInfo();
    int updateDepartment(@Param("dep") Dep dep);
    @MapKey("id")
    List<Map<String,Object>>queryDeptNameAndId();


}
