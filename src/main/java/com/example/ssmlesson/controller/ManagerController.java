package com.example.ssmlesson.controller;

import com.example.ssmlesson.pojo.Manager;
import com.example.ssmlesson.pojo.ResultVO;
import com.example.ssmlesson.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private  ManagerService managerService;
    //http://localhost:8083/manager/login
    @PostMapping("/login")
    public ResultVO login(@RequestBody Manager manager){
        ResultVO resultVO =managerService.login(manager.getUsername(),manager.getPassword());
        return  resultVO;
    }


}
