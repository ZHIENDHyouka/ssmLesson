package com.example.ssmlesson.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Emp {
    private  int empId;
    private  int postId;
    private  int titleId;
    private  String empName;
    private  int empSex;
    private  int empAge;
    private  String empTime;
}
