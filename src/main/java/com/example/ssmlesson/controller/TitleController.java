package com.example.ssmlesson.controller;

import com.example.ssmlesson.pojo.Title;
import com.example.ssmlesson.pojo.PageVO;
import com.example.ssmlesson.pojo.ResultVO;
import com.example.ssmlesson.service.TitleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/title")
public class TitleController {
    @Autowired
    private TitleService titleService;

    //http://localhost:8083/title/add
    @RequestMapping("/add")
    public ResultVO addTitle(@RequestBody Title title){
        ResultVO resultVO= titleService.addTitle(title);
        return resultVO;
    }
    //http://localhost:8083/title/del
    @RequestMapping("/del")
    public ResultVO deleteTitle(int id){
        ResultVO resultVO= titleService.deleteTitle(id);
        return resultVO;
    }
    //http://localhost:8083/title/udRemark
    @RequestMapping("/udRemark")
    public ResultVO updateTitleRemark(int titleId,String titleRemark){
        ResultVO resultVO= titleService.updateTitleRemark(titleId,titleRemark);
        return resultVO;
    }

    //http://localhost:8083/title/udMoney
    @RequestMapping("/udMoney")
    public ResultVO updateTitleMoney(int titleId,float titleMoney){
        ResultVO resultVO= titleService.updateTitleMoney(titleId,titleMoney);
        return resultVO;
    }

    //http://localhost:8083/title/selectTitle
    @RequestMapping("/selectTitle")
    public ResultVO selectTitle(int titleId){
        ResultVO resultVO= titleService.selectTitle(titleId);
        return resultVO;
    }
    //http://localhost:8083/title/selectTitleList
    @RequestMapping("/selectTitleList")
    public PageVO selectTitleList(int page , int limit ){
        PageVO pageVo= titleService.selectTitleList(page,limit);
        return pageVo;
    }

    @GetMapping("/queryAllTitleInfo")
    public ResultVO queryAllTitleInfo(){
        ResultVO resultVO = titleService.queryAllTitleInfo();
        return resultVO;
    }

    @PostMapping("/updateTitleInfo")
    public ResultVO updateTitleInfo(@RequestBody Title title){
        return titleService.updateTitleInfo(title);
    }


}
