package com.example.ssmlesson.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Dep {
    private int depId;
    private String depName;
    private String depRemark;//说明
    private float depMoney;//部门工资

}
