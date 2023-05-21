package com.example.ssmlesson.service;

import com.example.ssmlesson.dao.DepDAO;
import com.example.ssmlesson.pojo.Dep;
import com.example.ssmlesson.pojo.PageVO;
import com.example.ssmlesson.pojo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepService {
    @Autowired
    private DepDAO depDAO;

    public ResultVO addDep(Dep dep) {
        int a = depDAO.insertDep(dep);
        if (a > 0) {
            return new ResultVO(0, "成功", null);
        }
        return new ResultVO(0, "失败", null);

    }

    public ResultVO deleteDep(int depId){
        int a = depDAO.deleteDep(depId);
        if (a > 0) {
            return new ResultVO(0, "成功", null);
        }
        return new ResultVO(0, "失败", null);
    }

    public ResultVO updateDepRemark(int depId,String depRemark){
        int a =   depDAO.updateDepRemark(depId,depRemark);
        if (a > 0) {
            return new ResultVO(0, "成功", null);
        }
        return new ResultVO(0, "失败", null);
    }

    public ResultVO updateDepMoney(int depId,float depMoney){
        int a =   depDAO.updateDepMoney(depId,depMoney);
        if (a > 0) {
            return new ResultVO(0, "成功", null);
        }
        return new ResultVO(0, "失败", null);
    }

    public ResultVO selectDep(int depId){
        try {
            Dep dep =depDAO.selectDep(depId);
            return new ResultVO(0, "成功", dep);
        } catch (Exception e) {
            return new ResultVO(1, "失败", null);
        }

    }
    public PageVO selectDepList(int page,int limit){
        int start= (page-1)*limit;
        List<Dep> list = depDAO.selectDepList(start,limit);
        int count=depDAO.selectCount();
        PageVO pageVO=new PageVO(0,"查询成功",list,count);
        return pageVO;
    }




}
