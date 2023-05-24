package com.example.ssmlesson.controller;

import com.example.ssmlesson.pojo.Post;
import com.example.ssmlesson.pojo.PageVO;
import com.example.ssmlesson.pojo.ResultVO;
import com.example.ssmlesson.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.transform.Result;

@RestController
@CrossOrigin
@RequestMapping("/post")
public class PostController {
    @Autowired
    private PostService postService;

    //http://localhost:8083/post/add
    @RequestMapping("/add")
    public ResultVO addPost(@RequestBody Post post){
        ResultVO resultVO= postService.addPost(post);
        return resultVO;
    }
    //http://localhost:8083/post/del
    @RequestMapping("/del")
    public ResultVO deletePost(int id){
        ResultVO resultVO= postService.deletePost(id);
        return resultVO;
    }
    //http://localhost:8083/post/udRemark
    @RequestMapping("/udRemark")
    public ResultVO updatePostRemark(int postId,String postRemark){
        ResultVO resultVO= postService.updatePostRemark(postId,postRemark);
        return resultVO;
    }

    //http://localhost:8083/post/udMoney
    @RequestMapping("/udMoney")
    public ResultVO updatePostMoney(int postId,float postMoney){
        ResultVO resultVO= postService.updatePostMoney(postId,postMoney);
        return resultVO;
    }

    //http://localhost:8083/post/selectPost
    @RequestMapping("/selectPost")
    public ResultVO selectPost(int postId){
        ResultVO resultVO= postService.selectPost(postId);
        return resultVO;
    }
    //http://localhost:8083/post/selectPostList
    @RequestMapping("/selectPostList")
    public PageVO selectPostList(int page , int limit ){
        PageVO pageVo= postService.selectPostList(page,limit);
        return pageVo;
    }

    @GetMapping("/queryAllPostInfo")
    public ResultVO queryAllPostInfo(){
        return postService.queryAllPostInfo();
    }

    @PostMapping("/updatePostInfo")
    public ResultVO updatePostInfo(@RequestBody Post post){
        ResultVO resultVO = postService.updatePostInfo(post);
        return resultVO;
    }

}
