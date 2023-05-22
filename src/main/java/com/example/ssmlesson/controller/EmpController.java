package com.example.ssmlesson.controller;

import com.example.ssmlesson.dao.EmpDAO;
import com.example.ssmlesson.pojo.Emp;
import com.example.ssmlesson.pojo.PageVO;
import com.example.ssmlesson.pojo.ResultVO;
import com.example.ssmlesson.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/emp")
public class EmpController {
    @Autowired
    private EmpService empService;

    //http://localhost:8083/emp/add
    @RequestMapping("/add")
    public ResultVO addEmp(Emp emp){
        ResultVO resultVO= empService.addEmp(emp);
        return resultVO;
    }
    //http://localhost:8083/emp/del
    @RequestMapping("/del")
    public ResultVO deleteEmp(int empId){
        ResultVO resultVO= empService.deleteEmp(empId);
        return resultVO;
    }
    //http://localhost:8083/emp/udPost
    @RequestMapping("/udPost")
    public ResultVO updatePost(int empId,int postId){
        ResultVO resultVO= empService.updatePost(empId,postId);
        return resultVO;
    }

    //http://localhost:8083/emp/udTitle
    @RequestMapping("/udTitle")
    public ResultVO updateTitle(int empId,int titleId){
        ResultVO resultVO= empService.updateTitle(empId,titleId);
        return resultVO;
    }

    //http://localhost:8083/emp/selectEmp
    @RequestMapping("/selectEmp")
    public ResultVO selectEmp(int empId){
        ResultVO resultVO= empService.selectEmp(empId);
        return resultVO;
    }
    //http://localhost:8083/emp/selectEmpList
    @RequestMapping("/selectEmpList")
    public PageVO selectEmpList(int page , int limit ){
        PageVO pageVo= empService.selectEmpList(page,limit);
        return pageVo;
    }

}
