package io.simpolor.test.service;

import io.simpolor.test.repository.DemoRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DemoService.class})
public class DemoServiceMockBeanTest {

    @MockBean
    private DemoRepository demoRepository;

    @Autowired
    private DemoService demoService;

    @Test
    public void testDemoTotalcount() {

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