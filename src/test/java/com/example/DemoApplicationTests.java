package com.example;

import com.example.demo.SimpleSend;
import com.example.demo.SimpleSend1;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    SimpleSend simpleSend;
    @Autowired
    SimpleSend1 simpleSend1;

    @Test
    public void simpleSend() {
        simpleSend.send();
    }

    @Test
    public void simpleOneSend() {
        for (int i = 0; i < 100; i++) {
            simpleSend.send();
            simpleSend1.send();
        }
    }
}