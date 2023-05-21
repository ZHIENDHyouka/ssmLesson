package com.example.ssmlesson.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data

public class PageVO {

    //存储登录成功与否

        //code状态码：0登陆成功 1失败
        //msg提示信息：”账号不存在“
        //data: 数据/null
        private int code;
        private String msg;
        private Object data;
        //总记录数
        private int count ;



}
