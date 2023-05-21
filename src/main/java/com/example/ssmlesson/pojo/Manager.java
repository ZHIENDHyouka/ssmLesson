package com.example.ssmlesson.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Manager {
    private int managerId;//编号
    private String managerName;//账号
    private String managerPsw;//密码
    private String managerRealName;//真实姓名
}
