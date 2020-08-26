package io.simpolor.test.controller;

import io.simpolor.test.TestingApplication;
import io.simpolor.test.domain.Demo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

// @ExtendWith(SpringExtension.class) //junit5 버전 사용
// @ActiveProfiles("local") // 환경변수에 따른 테스트
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestingApplication.class , webEnvironment= SpringBootTest.WebEnvironment.RANDOM_PORT)
public class DemoIntergrationTest {

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

    // 단위 테스트 작성 시..
    // public class DealFinderTest {
    //      {...}
    // }

    //통합 테스트 작성 시..
    // public class UsableOptionDslRepositoryIntegrationTest extends IntegrationTest {
    //      {...}
    // }
}
