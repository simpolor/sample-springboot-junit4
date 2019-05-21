package io.simpolor.testing.service;

import io.simpolor.testing.repository.DemoRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.Mockito.when;

@SpringBootTest(classes = {DemoService.class})
public class DemoServiceMockBeanTest {

    @MockBean
    private DemoRepository demoRepository;

    @Autowired
    private DemoService demoService;

    @Test
    void testDemoTotalcount() {

        // given
        long reuturnValue = 3L;
        when(demoRepository.count()).thenReturn(reuturnValue);


        // when
        long result = demoService.totalcount();


        // then
        Assert.assertNotNull(result);
        Assert.assertEquals(3L, result);
    }
}