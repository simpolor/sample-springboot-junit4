package io.simpolor.test.service;

import io.simpolor.test.domain.Demo;
import org.junit.*;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

public class DemoServiceMockTest {

    @Mock
    private DemoService demoService;

    @Test
    public void testDemoTotalcount() {

        MockitoAnnotations.initMocks(this);

        // given
        long reuturnValue = 3L;
        when(demoService.totalcount()).thenReturn(reuturnValue);


        // when
        long result = demoService.totalcount();


        // then
        Assert.assertNotNull(result);
        Assert.assertEquals(3L, result);
    }



    @Test
    public void testDemoView() {

        MockitoAnnotations.initMocks(this);

        // given
        long seq = 5;

        Demo demo = new Demo();
        demo.setSeq(seq);
        demo.setName("단순색");
        demo.setAge(33);

        when(demoService.view(seq)).thenReturn(demo);


        // when
        Demo result = demoService.view(5);


        // then
        Assert.assertNotNull(result);
        Assert.assertEquals("단순색", result.getName());

    }
}