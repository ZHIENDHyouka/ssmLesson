package com.example.ssmlesson.service;

import com.example.ssmlesson.dao.DepDAO;
import com.example.ssmlesson.pojo.Dep;
import com.example.ssmlesson.pojo.PageVO;
import com.example.ssmlesson.pojo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    public ResultVO deleteDep(int depId) {
        int a = depDAO.deleteDep(depId);
        if (a > 0) {
            return new ResultVO(0, "成功", null);
        }
        return new ResultVO(0, "失败", null);
    }

    public ResultVO updateDepRemark(int depId, String depRemark) {
        int a = depDAO.updateDepRemark(depId, depRemark);
        if (a > 0) {
            return new ResultVO(0, "成功", null);
        }
        return new ResultVO(0, "失败", null);
    }

    public ResultVO updateDepMoney(int depId, float depMoney) {
        int a = depDAO.updateDepMoney(depId, depMoney);
        if (a > 0) {
            return new ResultVO(0, "成功", null);
        }
        return new ResultVO(0, "失败", null);
    }

    public ResultVO selectDep(int depId) {
        try {
            Dep dep = depDAO.selectDep(depId);
            return new ResultVO(0, "成功", dep);
        } catch (Exception e) {
            return new ResultVO(1, "失败", null);
        }

    }

    public PageVO selectDepList(int page, int limit) {
        int start = (page - 1) * limit;
        List<Dep> list = depDAO.selectDepList(start, limit);

        ArrayList<Map<String, Object>> headList = new ArrayList<>();
        HashMap<String, Object> headMap = new HashMap<>();
        headMap.put("id", "depName");
        headMap.put("name", "部门名称");
        HashMap<String, Object> headMap1 = new HashMap<>();
        headMap1.put("id", "depRemark");
        headMap1.put("name", "部门说明");
        HashMap<String, Object> headMap2 = new HashMap<>();
        headMap2.put("id", "depMoney");
        headMap2.put("name", "部门工资");

        headList.add(headMap);
        headList.add(headMap1);
        headList.add(headMap2);

        HashMap<String, Object> result = new HashMap<>();

        result.put("head", headList);
        result.put("data", list);
        int count = depDAO.selectCount();
        PageVO pageVO = new PageVO(0, "查询成功", result, count);
        return pageVO;
    }

    public ResultVO queryAllDepInfo() {
        List<Dep> dataList = depDAO.queryAllDepInfo();
        ArrayList<Map<String, Object>> headList = new ArrayList<>();
        HashMap<String, Object> headMap = new HashMap<>();
        headMap.put("id", "depName");
        headMap.put("name", "部门名称");
        HashMap<String, Object> headMap1 = new HashMap<>();
        headMap1.put("id", "depRemark");
        headMap1.put("name", "部门说明");
        HashMap<String, Object> headMap2 = new HashMap<>();
        headMap2.put("id", "depMoney");
        headMap2.put("name", "部门工资");
        headList.add(headMap);
        headList.add(headMap1);
        headList.add(headMap2);
        HashMap<String, Object> result = new HashMap<>();
        result.put("headList", headList);
        result.put("dataList", dataList);
        return new ResultVO(0, "查询成功", result);
    }

    public ResultVO updateDepartmentInfo(Dep dep) {
        int i = depDAO.updateDepartment(dep);
        if (i > 0) return new ResultVO(0, "修改成功", null);
        return new ResultVO(1, "修改失败捏，好像有bug了呢", null);
    }

    public ResultVO queryAllDeptNameAndId(){
        List<Map<String, Object>> maps = depDAO.queryDeptNameAndId();
        int code=0;
        String msg = "获取数据成功";
        if (!(maps.size()>0)) {
            code = 1;
            msg="数据获取失败，好像有bug捏";
        }
        return new ResultVO(code,msg,maps);
    }

}
