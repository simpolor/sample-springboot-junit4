package io.simpolor.testing.controller;

import io.simpolor.testing.domain.Demo;
import io.simpolor.testing.service.DemoService;
import org.junit.*;
import org.mockito.*;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

public class DemoControllerInjectMocksTest {

    @Mock
    private DemoService demoService;

    @InjectMocks
    private DemoController demoController;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testDemoTotalcount() {

        // given
        long returnValue = 15L;
        when(demoService.totalcount()).thenReturn(returnValue);


        // when
        long reuslt = demoController.demoTotalCount();


        // than
        Assert.assertEquals(15L, reuslt);

    }

    @Test
    public void testDemoList() {

        // given
        List<Demo> list = new ArrayList<>();
        list.add(new Demo(1, "김영희", 17));
        list.add(new Demo(2, "김철수", 18));

        when(demoService.list()).thenReturn(list);


        // when
        List<Demo> actual = demoController.demoList();


        // than
        Assert.assertEquals(2L, actual.size());
        Assert.assertEquals("김철수", actual.get(1).getName());
    }

    @Test
    public void testDemoView() {

        // given
        when(demoService.view(1L)).thenReturn(new Demo(1, "김영희", 17));


        // when
        Demo actual = demoController.demoView(1L);


        // than
        Assert.assertNotNull(actual);
        Assert.assertEquals(17, actual.getAge());
        Assert.assertEquals("김영희", actual.getName());
    }

    @Test
    public void testDemoWrite() {

        // given
        Demo demo = new Demo(0L, "김영희", 17);
        Demo result = new Demo(2L, "김영희", 17);
        when(demoService.write(demo)).thenReturn(result);


        // when
        Demo actual = demoController.demoWrite(demo);


        // than
        Assert.assertNotNull(actual);
        Assert.assertEquals(result, actual);
        Assert.assertEquals(result.getName(), actual.getName());
    }

    @Test
    public void testDemoModify() {

        // given
        long seq = 2L;
        Demo demo = new Demo(2L, "김영희", 18);
        when(demoService.modify(demo)).thenReturn(demo);


        // when
        Demo actual = demoController.demoModify(seq, demo);


        // than
        Assert.assertNotNull(actual);
        Assert.assertEquals(demo, actual);
        Assert.assertEquals(demo.getName(), actual.getName());
    }

    @Test
    public void testDemoDelete() {

        // given
        long seq = 2L;
        when(demoService.delete(seq)).thenReturn(seq);


        // when
        long actual = demoController.demoDelete(seq);


        // than
        Assert.assertNotNull(actual);
        Assert.assertEquals(seq, actual);
    }

}