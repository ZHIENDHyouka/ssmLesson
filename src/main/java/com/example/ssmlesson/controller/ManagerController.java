package com.example.ssmlesson.controller;

import com.example.ssmlesson.pojo.ResultVO;
import com.example.ssmlesson.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/manager")
public class ManagerController {

    @Autowired
    private  ManagerService managerService;
    //http://localhost:8083/manager/login
    @RequestMapping("/login")
    public ResultVO login(String managerName,String managerPsw){
        ResultVO resultVO =managerService.login(managerName,managerPsw);
        return  resultVO;
    }


}
