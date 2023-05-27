package com.example.ssmlesson.controller;

import com.example.ssmlesson.pojo.Kq;
import com.example.ssmlesson.pojo.PageVO;
import com.example.ssmlesson.pojo.ResultVO;
import com.example.ssmlesson.service.KqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@CrossOrigin
@RequestMapping("/kq")
public class KqController {
    @Autowired
    private KqService kqService;

    //http://localhost:8083/kq/add
    @RequestMapping("/add")
    public ResultVO addKq(@RequestBody Map addMap){
        ResultVO resultVO= kqService.addKq(addMap);
        return resultVO;
    }
    //http://localhost:8083/kq/del
    @RequestMapping("/del")
    public ResultVO deleteKq(int id){
        ResultVO resultVO= kqService.deleteKq(id);
        return resultVO;
    }
    //http://localhost:8083/kq/selectKq
    @RequestMapping("/selectKq")
    public ResultVO selectKq(int kqId){
        ResultVO resultVO= kqService.selectKq(kqId);
        return resultVO;
    }
    //http://localhost:8083/kq/selectKqList
    @RequestMapping("/selectKqList")
    public PageVO selectKqList(int page , int limit ){
        PageVO pageVo= kqService.selectKqList(page,limit);
        return pageVo;
    }

    @GetMapping("/queryAllKqInfo")
    public ResultVO queryAllKqInfo(){
        return kqService.queryAllKqInfo();
    }

}
