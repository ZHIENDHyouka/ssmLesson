package com.example.ssmlesson.controller;

import com.example.ssmlesson.pojo.Kq;
import com.example.ssmlesson.pojo.PageVO;
import com.example.ssmlesson.pojo.ResultVO;
import com.example.ssmlesson.service.KqService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/kq")
public class KqController {
    @Autowired
    private KqService kqService;

    //http://localhost:8083/kq/add
    @RequestMapping("/add")
    public ResultVO addKq(Kq kq){
        ResultVO resultVO= kqService.addKq(kq);
        return resultVO;
    }
    //http://localhost:8083/kq/del
    @RequestMapping("/del")
    public ResultVO deleteKq(int kqId){
        ResultVO resultVO= kqService.deleteKq(kqId);
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

}
