package com.example.ssmlesson.service;

import com.example.ssmlesson.dao.PostDAO;
import com.example.ssmlesson.pojo.Post;
import com.example.ssmlesson.pojo.PageVO;
import com.example.ssmlesson.pojo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class PostService {
    @Autowired
    private PostDAO postDAO;

    public ResultVO addPost(Post post) {
        int a = postDAO.insertPost(post);
        if (a > 0) {
            return new ResultVO(0, "成功", null);
        }
        return new ResultVO(0, "失败", null);

    }

    public ResultVO deletePost(int postId){
        int a = postDAO.deletePost(postId);
        if (a > 0) {
            return new ResultVO(0, "成功", null);
        }
        return new ResultVO(0, "失败", null);
    }

    public ResultVO updatePostRemark(int postId,String postRemark){
        int a =   postDAO.updatePostRemark(postId,postRemark);
        if (a > 0) {
            return new ResultVO(0, "成功", null);
        }
        return new ResultVO(0, "失败", null);
    }

    public ResultVO updatePostMoney(int postId,float postMoney){
        int a =   postDAO.updatePostMoney(postId,postMoney);
        if (a > 0) {
            return new ResultVO(0, "成功", null);
        }
        return new ResultVO(0, "失败", null);
    }

    public ResultVO selectPost(int postId){
        try {
            Post post =postDAO.selectPost(postId);
            return new ResultVO(0, "成功", post);
        } catch (Exception e) {
            return new ResultVO(1, "失败", null);
        }

    }
    public PageVO selectPostList(int page, int limit){
        int start= (page-1)*limit;
        List<Post> list = postDAO.selectPostList(start,limit);

        ArrayList<Map<String, Object>> headList = new ArrayList<>();
        HashMap<String, Object> headMap = new HashMap<>();
        headMap.put("id", "depId");
        headMap.put("name", "部门编号");
        HashMap<String, Object> headMap1 = new HashMap<>();
        headMap1.put("id", "postName");
        headMap1.put("name", "岗位名称");
        HashMap<String, Object> headMap2 = new HashMap<>();
        headMap2.put("id", "postRemark");
        headMap2.put("name", "岗位说明");
        HashMap<String, Object> headMap3 = new HashMap<>();
        headMap3.put("id", "postMoney");
        headMap3.put("name", "岗位工资");

        headList.add(headMap);
        headList.add(headMap1);
        headList.add(headMap2);
        headList.add(headMap3);

        HashMap<String, Object> result = new HashMap<>();

        result.put("head",headList);
        result.put("data",list);
        int count=postDAO.selectCount();
        PageVO pageVO=new PageVO(0,"查询成功",result,count);
        return pageVO;
    }

    public ResultVO queryAllPostInfo(){
        List<Map<String, Object>> dataList = postDAO.queryAllPostInfo();
        ArrayList<Map<String, Object>> headList = new ArrayList<>();
        HashMap<String, Object> headMap = new HashMap<>();
        headMap.put("id", "postId");
        headMap.put("name", "岗位编号");
        HashMap<String, Object> headMap1 = new HashMap<>();
        headMap1.put("id", "depName");
        headMap1.put("name", "部门名称");
        HashMap<String, Object> headMap2 = new HashMap<>();
        headMap2.put("id", "postName");
        headMap2.put("name", "岗位名称");
        HashMap<String, Object> headMap3 = new HashMap<>();
        headMap3.put("id", "postRemark");
        headMap3.put("name", "岗位说明");
        HashMap<String, Object> headMap4 = new HashMap<>();
        headMap4.put("id", "postMoney");
        headMap4.put("name", "岗位工资");

        headList.add(headMap);
        headList.add(headMap1);
        headList.add(headMap2);
        headList.add(headMap3);
        headList.add(headMap4);

        HashMap<String, Object> result = new HashMap<>();

        result.put("headList",headList);
        result.put("dataList",dataList);
        return new ResultVO(0,"获取成功",result);
    }

    public ResultVO updatePostInfo(Post post){
        if (postDAO.updatePostInfo(post)>0) return new ResultVO(0,"修改成功!",null);
        return null;
    }

}
