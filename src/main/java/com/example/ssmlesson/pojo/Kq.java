package com.example.ssmlesson.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Kq {
    private int kqId;
    private int empId;
    private int kqY;//年
    private int kqM;//月
    private int kqAll;//异常统计

}
