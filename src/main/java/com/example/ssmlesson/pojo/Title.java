package com.example.ssmlesson.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Title {
    private int titleId;
    private String titleName;
    private String titleRemark;
    private float titleMoney;//职称工资
}
