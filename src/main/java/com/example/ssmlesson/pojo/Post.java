package com.example.ssmlesson.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Post {
    private int postId;
    private int depId;
    private String postName;
    private String postRemark;
    private float postMoney;//岗位工资
}
