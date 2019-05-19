package io.simpolor.testing.controller;

import io.simpolor.testing.domain.Demo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class) //junit5 버전 사용
@SpringBootTest // springboot 통합 테스트
// @ActiveProfiles("local") // 환경변수에 따른 테스트
// @Category(DemoController.class) // 테스트에 따른 분류
class DemoIntegrationTest {

    @Autowired
    private DemoController demoController;

    @Test
    void demo() {

        // given
        // HttpServletRequest request = mock(HttpServletRequest.class);
        long seq = 3884;


        // when
        Demo result = demoController.demoView(seq);


        // then
        Assert.assertNotNull(result);
        Assert.assertEquals("진애을", result.getName());

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