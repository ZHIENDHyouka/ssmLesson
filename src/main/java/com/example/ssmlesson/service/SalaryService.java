package com.example.ssmlesson.service;

import com.example.ssmlesson.dao.*;
import com.example.ssmlesson.pojo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SalaryService {
    @Autowired
    private SalaryDAO salaryDAO;
    @Autowired
    private KqDAO kqDAO;
    @Autowired
    private EmpDAO empDAO;
    @Autowired
    private TitleDAO titleDAO;
    @Autowired
    private PostDAO postDAO;
    @Autowired
    private DepDAO depDAO;


    public ResultVO addS(Salary salary) {
        float s= 0;
        int  empId = salary.getEmpId();
        int kqId = salary.getKqId();
       Emp emp= empDAO.selectEmp(empId);
      int postId= emp.getPostId();
     int depId= postDAO.selectPost(postId).getDepId();
        int titleId= emp.getTitleId();
        float dM=depDAO.selectDep(depId).getDepMoney(); //部门工资
        float pM = postDAO.selectPost(postId).getPostMoney();//岗位工资
        float tM = titleDAO.selectTitle(titleId).getTitleMoney();//职称工资
        int d = kqDAO.selectKq(kqId).getKqAll();//异常统计

         s =(dM+pM+tM)/22*(22-d);
         salary.setSalaryAll(s);

        int a = salaryDAO.insertS(salary);
        if (a > 0) {
            return new ResultVO(0, "成功", null);
        }
        return new ResultVO(0, "失败", null);

    }

    public ResultVO deleteS(int salaryId){
        int a = salaryDAO.deleteS(salaryId);
        if (a > 0) {
            return new ResultVO(0, "成功", null);
        }
        return new ResultVO(0, "失败", null);
    }


    public ResultVO selectS(int salaryId){
        try {
            Salary salary =salaryDAO.selectS(salaryId);
            return new ResultVO(0, "成功", salary);
        } catch (Exception e) {
            return new ResultVO(1, "失败", null);
        }

    }
    public PageVO selectSList(int page, int limit){
        int start= (page-1)*limit;
        List<Salary> list = salaryDAO.selectSList(start,limit);

        ArrayList<Map<String, Object>> headList = new ArrayList<>();
        HashMap<String, Object> headMap = new HashMap<>();
        headMap.put("id", "empId");
        headMap.put("name", "员工id");
        HashMap<String, Object> headMap1 = new HashMap<>();
        headMap1.put("id", "kqId");
        headMap1.put("name", "考勤id");
        HashMap<String, Object> headMap2 = new HashMap<>();
        headMap2.put("id", "salaryAll");
        headMap2.put("name", "应发工资");


        headList.add(headMap);
        headList.add(headMap1);
        headList.add(headMap2);

        HashMap<String, Object> result = new HashMap<>();

        result.put("head",headList);
        result.put("data",list);
        int count=salaryDAO.selectCount();
        PageVO pageVO=new PageVO(0,"查询成功",result,count);
        return pageVO;
    }


}
