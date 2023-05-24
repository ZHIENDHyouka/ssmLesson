package com.example.ssmlesson.dao;

import com.example.ssmlesson.pojo.Post;
import javafx.geometry.Pos;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PostDAO {
    public int insertPost(Post post);
    public int deletePost(int postId);
    public int  updatePostRemark(@Param("i")int postId, @Param("r") String postRemark);
    public int updatePostMoney(@Param("i")int postId,@Param("m")float postMoney);
    public Post selectPost(int postId);
    public List<Post> selectPostList(@Param("s")  int start , @Param("l") int limit);
    public int selectCount();
    List<Post> queryAllPostInfo();
    int updatePostInfo(@Param("post")Post post);


}
