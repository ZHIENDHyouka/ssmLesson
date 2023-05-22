package com.example.ssmlesson.service;

import com.example.ssmlesson.dao.TitleDAO;
import com.example.ssmlesson.pojo.Title;
import com.example.ssmlesson.pojo.PageVO;
import com.example.ssmlesson.pojo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TitleService {
    @Autowired
    private TitleDAO titleDAO;

    public ResultVO addTitle(Title title) {
        int a = titleDAO.insertTitle(title);
        if (a > 0) {
            return new ResultVO(0, "成功", null);
        }
        return new ResultVO(0, "失败", null);

    }

    public ResultVO deleteTitle(int titleId){
        int a = titleDAO.deleteTitle(titleId);
        if (a > 0) {
            return new ResultVO(0, "成功", null);
        }
        return new ResultVO(0, "失败", null);
    }

    public ResultVO updateTitleRemark(int titleId,String titleRemark){
        int a =   titleDAO.updateTitleRemark(titleId,titleRemark);
        if (a > 0) {
            return new ResultVO(0, "成功", null);
        }
        return new ResultVO(0, "失败", null);
    }

    public ResultVO updateTitleMoney(int titleId,float titleMoney){
        int a =   titleDAO.updateTitleMoney(titleId,titleMoney);
        if (a > 0) {
            return new ResultVO(0, "成功", null);
        }
        return new ResultVO(0, "失败", null);
    }

    public ResultVO selectTitle(int titleId){
        try {
            Title title =titleDAO.selectTitle(titleId);
            return new ResultVO(0, "成功", title);
        } catch (Exception e) {
            return new ResultVO(1, "失败", null);
        }

    }
    public PageVO selectTitleList(int page, int limit){
        int start= (page-1)*limit;
        List<Title> list = titleDAO.selectTitleList(start,limit);

        ArrayList<Map<String, Object>> headList = new ArrayList<>();
        HashMap<String, Object> headMap = new HashMap<>();
        headMap.put("id", "titleName");
        headMap.put("name", "职称名称");
        HashMap<String, Object> headMap1 = new HashMap<>();
        headMap1.put("id", "titleRemark");
        headMap1.put("name", "职称说明");
        HashMap<String, Object> headMap2 = new HashMap<>();
        headMap2.put("id", "titleMoney");
        headMap2.put("name", "职称工资");

        headList.add(headMap);
        headList.add(headMap1);
        headList.add(headMap2);

        HashMap<String, Object> result = new HashMap<>();

        result.put("head",headList);
        result.put("data",list);
        int count=titleDAO.selectCount();
        PageVO pageVO=new PageVO(0,"查询成功",result,count);
        return pageVO;
    }




}
