package com.yly.webdemo;

import com.yly.webdemo.bean.Human;
import com.yly.webdemo.mapper.HumanMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private HumanMapper humanMapper;

    @Test
    public void testInsert() throws Exception {
        humanMapper.insert(new Human("testA", 22));
        humanMapper.insert(new Human("testtest", 22));
    }

}
