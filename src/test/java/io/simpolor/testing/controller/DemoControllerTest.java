package io.simpolor.testing.controller;

import io.simpolor.testing.domain.Demo;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Mockito.when;

class DemoControllerTest {

    @Mock
    DemoController demoController;

    @Test
    public void demoTest() {

        MockitoAnnotations.initMocks(this);

        // given
        long seq = 3884;

        Demo demo = new Demo();
        demo.setSeq(seq);
        demo.setName("진애을");
        demo.setAge(23);
        demo.setHobby("축구");

        when(demoController.demoView(seq)).thenReturn(demo);


        // when
        Demo result = demoController.demoView(seq);


        // then
        Assert.assertNotNull(result);
        Assert.assertEquals("진애을", result.getName());

    }

}