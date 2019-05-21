package io.simpolor.testing.controller;

import io.simpolor.testing.service.DemoService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import static org.mockito.Mockito.when;

public class DemoControllerInjectMocksTest {

    @InjectMocks
    private DemoController demoController;

    @Mock
    private DemoService demoService;

    @Test
    public void testDemoTotalcount() throws Exception {

        MockitoAnnotations.initMocks(this);

        long returnValue = 15L;
        when(demoService.totalcount()).thenReturn(returnValue);

        long reuslt = demoController.demoTotalCount();
        Assert.assertEquals(15L, reuslt);

    }

}