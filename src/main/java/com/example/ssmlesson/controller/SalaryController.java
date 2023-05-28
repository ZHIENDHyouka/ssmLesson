package com.example.ssmlesson.controller;

import com.example.ssmlesson.pojo.Kq;
import com.example.ssmlesson.pojo.PageVO;
import com.example.ssmlesson.pojo.ResultVO;
import com.example.ssmlesson.pojo.Salary;
import com.example.ssmlesson.service.KqService;
import com.example.ssmlesson.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/salary")
public class SalaryController {
    @Autowired
    private SalaryService salaryService;

    //http://localhost:8083/salary/add
    @RequestMapping("/add")
    public ResultVO addKq(@RequestBody Salary salary){
        ResultVO resultVO= salaryService.addS(salary);
        return resultVO;
    }
    //http://localhost:8083/salary/del
    @RequestMapping("/del")
    public ResultVO deleteS(int id){
        ResultVO resultVO= salaryService.deleteS(id);
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

    @GetMapping("/queryAllSalaryInfo")
    public ResultVO queryAllSalaryInfo(){
        return salaryService.queryAllSalaryInfo();
    }

}
