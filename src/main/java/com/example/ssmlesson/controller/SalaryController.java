package com.example.ssmlesson.controller;

import com.example.ssmlesson.pojo.Kq;
import com.example.ssmlesson.pojo.PageVO;
import com.example.ssmlesson.pojo.ResultVO;
import com.example.ssmlesson.pojo.Salary;
import com.example.ssmlesson.service.KqService;
import com.example.ssmlesson.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/salary")
public class SalaryController {
    @Autowired
    private SalaryService salaryService;

    //http://localhost:8083/salary/add
    @RequestMapping("/add")
    public ResultVO addKq(Salary salary){
        ResultVO resultVO= salaryService.addS(salary);
        return resultVO;
    }
    //http://localhost:8083/salary/del
    @RequestMapping("/del")
    public ResultVO deleteS(int salaryId){
        ResultVO resultVO= salaryService.deleteS(salaryId);
        return resultVO;
    }
    //http://localhost:8083/salary/selectS
    @RequestMapping("/selectS")
    public ResultVO selectS(int salaryId){
        ResultVO resultVO= salaryService.selectS(salaryId);
        return resultVO;
    }
    //http://localhost:8083/salary/selectSList
    @RequestMapping("/selectSList")
    public PageVO selectKqList(int page , int limit ){
        PageVO pageVo= salaryService.selectSList(page,limit);
        return pageVo;
    }

}
