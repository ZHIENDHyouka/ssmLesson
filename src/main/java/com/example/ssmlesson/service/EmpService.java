package com.example.ssmlesson.service;

import com.example.ssmlesson.dao.EmpDAO;
import com.example.ssmlesson.pojo.Dep;
import com.example.ssmlesson.pojo.Emp;
import com.example.ssmlesson.pojo.PageVO;
import com.example.ssmlesson.pojo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmpService {
    @Autowired
    private EmpDAO empDAO;

    public ResultVO addEmp(Emp emp) {
        int a = empDAO.insertEmp(emp);
        if (a > 0) {
            return new ResultVO(0, "成功", null);
        }
        return new ResultVO(0, "失败", null);

    }

    public ResultVO deleteEmp(int empId) {
        int a = empDAO.deleteEmp(empId);
        if (a > 0) {
            return new ResultVO(0, "成功", null);
        }
        return new ResultVO(0, "失败", null);
    }

    public ResultVO updatePost(int empId, int postId) {
        int a = empDAO.updatePost(empId, postId);
        if (a > 0) {
            return new ResultVO(0, "成功", null);
        }
        return new ResultVO(0, "失败", null);
    }

    public ResultVO updateTitle(int empId, int titleId) {
        int a = empDAO.updateTitle(empId, titleId);
        if (a > 0) {
            return new ResultVO(0, "成功", null);
        }
        return new ResultVO(0, "失败", null);
    }

    public ResultVO selectEmp(int empId) {
        try {
            Emp emp = empDAO.selectEmp(empId);
            return new ResultVO(0, "成功", emp);
        } catch (Exception e) {
            return new ResultVO(1, "失败", null);
        }

    }

    public PageVO selectEmpList(int page, int limit) {
        int start = (page - 1) * limit;
        List<Emp> list = empDAO.selectEmpList(start, limit);

        ArrayList<Map<String, Object>> headList = new ArrayList<>();
        HashMap<String, Object> headMap = new HashMap<>();
        headMap.put("id", "postId");
        headMap.put("name", "岗位名称");

        HashMap<String, Object> headMap1 = new HashMap<>();
        headMap1.put("id", "titleId");
        headMap1.put("name", "职称");

        HashMap<String, Object> headMap2 = new HashMap<>();
        headMap2.put("id", "empName");
        headMap2.put("name", "员工姓名");

        HashMap<String, Object> headMap3 = new HashMap<>();
        headMap3.put("id", "empSex");
        headMap3.put("name", "员工性别");

        HashMap<String, Object> headMap4 = new HashMap<>();
        headMap4.put("id", "empAge");
        headMap4.put("name", "员工年龄");

        HashMap<String, Object> headMap5 = new HashMap<>();
        headMap5.put("id", "empTime");
        headMap5.put("name", "入职时间");

        headList.add(headMap);
        headList.add(headMap1);
        headList.add(headMap2);
        headList.add(headMap3);
        headList.add(headMap4);
        headList.add(headMap5);

        HashMap<String, Object> result = new HashMap<>();

        result.put("head", headList);
        result.put("data", list);
        int count = empDAO.selectCount();
        PageVO pageVO = new PageVO(0, "查询成功", result, count);
        return pageVO;
    }

    public ResultVO queryAllEmpInfo(){
        List<Map<String, Object>> dataList = empDAO.queryAllEmpInfo();
        List<Map<String, Object>> headList = new ArrayList<>();
        HashMap<String, Object> headMap = new HashMap<>();
        headMap.put("id", "empId");
        headMap.put("name", "工号");

        HashMap<String, Object> headMap1 = new HashMap<>();
        headMap1.put("id", "postName");
        headMap1.put("name", "岗位名称");

        HashMap<String, Object> headMap2 = new HashMap<>();
        headMap2.put("id", "titleName");
        headMap2.put("name", "职称");

        HashMap<String, Object> headMap3 = new HashMap<>();
        headMap3.put("id", "empName");
        headMap3.put("name", "员工姓名");

        HashMap<String, Object> headMap4 = new HashMap<>();
        headMap4.put("id", "empSex");
        headMap4.put("name", "员工性别");

        HashMap<String, Object> headMap5 = new HashMap<>();
        headMap5.put("id", "empAge");
        headMap5.put("name", "员工年龄");

        HashMap<String, Object> headMap6 = new HashMap<>();
        headMap6.put("id", "empTime");
        headMap6.put("name", "入职时间");

        headList.add(headMap);
        headList.add(headMap1);
        headList.add(headMap2);
        headList.add(headMap3);
        headList.add(headMap4);
        headList.add(headMap5);

        HashMap<String, Object> result = new HashMap<>();

        result.put("headList", headList);
        result.put("dataList", dataList);
        return new ResultVO(0,"查询成功",result);
    }


}
