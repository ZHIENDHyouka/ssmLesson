package com.example.ssmlesson;

import com.example.ssmlesson.dao.DepDAO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

@SpringBootTest
class SsmLessonApplicationTests {
    @Autowired
    DepDAO depDAO;
    @Test
    void contextLoads() {
        List<Map<String, Object>> maps = depDAO.queryDeptNameAndId();
        System.out.println(maps);
    }

}
