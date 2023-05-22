package com.example.ssmlesson.service;

import com.example.ssmlesson.dao.KqDAO;
import com.example.ssmlesson.pojo.Kq;
import com.example.ssmlesson.pojo.PageVO;
import com.example.ssmlesson.pojo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class KqService {

    @Autowired
    private KqDAO kqDAO;

    public ResultVO addKq(Kq kq) {
        int a = kqDAO.insertKq(kq);
        if (a > 0) {
            return new ResultVO(0, "成功", null);
        }
        return new ResultVO(0, "失败", null);

    }

    public ResultVO deleteKq(int kqId){
        int a = kqDAO.deleteKq(kqId);
        if (a > 0) {
            return new ResultVO(0, "成功", null);
        }
        return new ResultVO(0, "失败", null);
    }


    public ResultVO selectKq(int kqId){
        try {
            Kq kq =kqDAO.selectKq(kqId);
            return new ResultVO(0, "成功", kq);
        } catch (Exception e) {
            return new ResultVO(1, "失败", null);
        }

    }
    public PageVO selectKqList(int page, int limit){
        int start= (page-1)*limit;
        List<Kq> list = kqDAO.selectKqList(start,limit);

        ArrayList<Map<String, Object>> headList = new ArrayList<>();
        HashMap<String, Object> headMap = new HashMap<>();
        headMap.put("id", "empId");
        headMap.put("name", "员工id");
        HashMap<String, Object> headMap1 = new HashMap<>();
        headMap1.put("id", "kqY");
        headMap1.put("name", "年");
        HashMap<String, Object> headMap2 = new HashMap<>();
        headMap2.put("id", "kqM");
        headMap2.put("name", "月");
        HashMap<String, Object> headMap3 = new HashMap<>();
        headMap3.put("id", "kqAll");
        headMap3.put("name", "异常统计");

        headList.add(headMap);
        headList.add(headMap1);
        headList.add(headMap2);
        headList.add(headMap3);

        HashMap<String, Object> result = new HashMap<>();

        result.put("head",headList);
        result.put("data",list);
        int count=kqDAO.selectCount();
        PageVO pageVO=new PageVO(0,"查询成功",result,count);
        return pageVO;
    }




}
