package io.simpolor.test.controller;

import io.simpolor.test.domain.Demo;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

public class DemoControllerTest {

    @Mock
    private DemoController demoController;

    @Test
    public void testDemoView() {

        MockitoAnnotations.initMocks(this);

        // given
        long seq = 5;

        Demo demo = new Demo();
        demo.setSeq(seq);
        demo.setName("단순색");
        demo.setAge(33);

        when(demoController.demoView(seq)).thenReturn(demo);


        // when
        Demo result = demoController.demoView(5);


        // then
        Assert.assertNotNull(result);
        Assert.assertEquals("단순색", result.getName());

    }

}