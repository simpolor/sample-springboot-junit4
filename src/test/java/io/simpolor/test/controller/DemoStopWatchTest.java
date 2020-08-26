package io.simpolor.test.controller;

import io.simpolor.test.TestingApplication;
import io.simpolor.test.domain.Demo;
import org.junit.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StopWatch;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestingApplication.class , webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DemoStopWatchTest {

    private StopWatch stopWatch;

    @Autowired
    private DemoController demoController;

    @Before
    public void setup() {
        stopWatch = new StopWatch("simpolor");
    }


    @Test
    public void testDemoIntergration(){

        // given
        BigDecimal bigDecimal = BigDecimal.valueOf(0, 0);
        Long longType = 0L;

        long seq = 1;


        // when
        Demo result = demoController.demoView(seq);

        stopWatch.start("Long type");
        for(int i = 0; i < 1_000_000; i++) {
            longType += 1L;
        }
        stopWatch.stop();

        stopWatch.start("BigDecimal type");
        for(int i = 0; i < 1_000_000; i++) {
            bigDecimal = bigDecimal.add(BigDecimal.ONE);
        }
        stopWatch.stop();

        // then
        Assert.assertNotNull(result);
        System.out.println("stopWatch.shortSummary : "+stopWatch.shortSummary());
        System.out.println("stopWatch.getTotalTimeMillis : "+stopWatch.getTotalTimeMillis());
        System.out.println("stopWatch.prettyPrint : "+stopWatch.prettyPrint());
    }

}
