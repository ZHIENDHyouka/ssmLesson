package com.example.ssmlesson.controller;

import com.example.ssmlesson.pojo.Dep;
import com.example.ssmlesson.pojo.PageVO;
import com.example.ssmlesson.pojo.ResultVO;
import com.example.ssmlesson.service.DepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/dep")
public class DepController {
    @Autowired
    private DepService depService;

    //http://localhost:8083/dep/add
    @RequestMapping("/add")
    public ResultVO addDep(Dep dep){
       ResultVO resultVO= depService.addDep(dep);
       return resultVO;
    }
    //http://localhost:8083/dep/del
    @RequestMapping("/del")
    public ResultVO deleteDep(int depId){
        ResultVO resultVO= depService.deleteDep(depId);
        return resultVO;
    }
    //http://localhost:8083/dep/udRemark
    @RequestMapping("/udRemark")
    public ResultVO updateDepRemark(int depId,String depRemark){
        ResultVO resultVO= depService.updateDepRemark(depId,depRemark);
        return resultVO;
    }

    //http://localhost:8083/dep/udMoney
    @RequestMapping("/udMoney")
    public ResultVO updateDepMoney(int depId,float depMoney){
        ResultVO resultVO= depService.updateDepMoney(depId,depMoney);
        return resultVO;
    }

    //http://localhost:8083/dep/selectDep
    @RequestMapping("/selectDep")
    public ResultVO selectDep(int depId){
        ResultVO resultVO= depService.selectDep(depId);
        return resultVO;
    }
    //http://localhost:8083/dep/selectDepList
    @RequestMapping("/selectDepList")
    public PageVO selectDepList(int page , int limit ){
        PageVO pageVo= depService.selectDepList(page,limit);
        return pageVo;
    }



}
