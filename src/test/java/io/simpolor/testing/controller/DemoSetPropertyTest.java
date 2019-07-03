package io.simpolor.testing.controller;

import io.simpolor.testing.TestingApplication;
import io.simpolor.testing.domain.Demo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(
        classes = TestingApplication.class,
        webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT
        // properties = {"jasypt.encryptor.password=simpolor"}
)
public class DemoSetPropertyTest {

    /* static{
        System.setProperty("jasypt.encryptor.password", "simpolor");
    } */

    @Autowired
    private DemoController demoController;

    @Test
    public void testDemoIntergration(){

        // given
        long seq = 1;


        // when
        Demo result = demoController.demoView(seq);


        // then
        Assert.assertNotNull(result);
    }
}
