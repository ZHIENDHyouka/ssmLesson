package com.example.ssmlesson.service;

import com.example.ssmlesson.Util.MD5Utils;
import com.example.ssmlesson.dao.ManagerDAO;
import com.example.ssmlesson.pojo.Manager;
import com.example.ssmlesson.pojo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ManagerService {

    @Autowired
    private ManagerDAO managerDAO;

    public ResultVO login(String managerName,String managerPsw){
        String pwd = null;
        //根据管理员id查询管理员信息
        Manager manager =managerDAO.selectManager(managerName);
        pwd = manager == null ? null : manager.getPassword();

        if (pwd == null) {// 账号为空时，密码为空。查询失败
            return new ResultVO(1, "账号错误", null);
        } else {
            /*
            密码不为空，表示查到信息
            * */
            //对输入密码进行加密
            managerPsw= MD5Utils.md5(managerPsw);
            if (managerPsw.equals(pwd)) {
                return new ResultVO(0, "登陆成功",manager.getManagerRealName());
            } else {
                return new ResultVO(1, "密码错误", null);
            }
        }
    }


}
