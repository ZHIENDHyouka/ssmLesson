package com.example.ssmlesson.dao;

import com.example.ssmlesson.pojo.Post;
import javafx.geometry.Pos;

import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

@Mapper
public interface PostDAO {
    public int insertPost(Post post);
    public int deletePost(int postId);
    public int  updatePostRemark(@Param("i")int postId, @Param("r") String postRemark);
    public int updatePostMoney(@Param("i")int postId,@Param("m")float postMoney);
    public Post selectPost(int postId);
    public List<Post> selectPostList(@Param("s")  int start , @Param("l") int limit);
    public int selectCount();
    @MapKey("id")
    List<Map<String,Object>> queryAllPostInfo();
    int updatePostInfo(@Param("post")Post post);
    @MapKey("p_id")
    List<Map<String,Object>> queryPostIdName();


}
