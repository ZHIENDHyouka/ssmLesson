package com.example.ssmlesson.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class salary {
    private int salaryId;
    private int empId;
    private float salaryAll;//实发工资
}
