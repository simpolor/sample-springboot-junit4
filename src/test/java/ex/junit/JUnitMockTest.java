package ex.junit;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

import javax.servlet.http.HttpServletRequest;

import io.simpolor.testing.controller.DemoController;
import io.simpolor.testing.domain.Demo;
import io.simpolor.testing.service.DemoService;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.Answer;
import reflection.DemoReflection;

public class JUnitMockTest {

    @Mock
    HttpServletRequest request;

    @Mock
    DemoService demoService;

    @InjectMocks
    DemoController demoController;

    @Test
    public void testDemoMoc() {

        // given
        long seq = 1;

        // Mock Annotations이 선언된 객체를 찾아 Mock객체를 생성
        // InjectMocks을 사용하기 위한 작업
        MockitoAnnotations.initMocks(this);

        Demo givenSuccessDemoResult = DemoReflection.exampleDemoResult(1, "test", 19);

        when(demoService.view(anyLong())).thenReturn(givenSuccessDemoResult);


        // when
        Demo result = demoController.demoView(seq);


        // then
        Assert.assertNotNull(result);
    }

    @Test
    public void testMockSpy(){

        Demo demo = spy(Demo.class);

        MockitoAnnotations.initMocks(this);
        Assert.assertTrue(demo != null);
    }

    @Test
    public void testDemoWhenThenReturn() {

        // given
        long seq = 1;

        // Mock Annotations이 선언된 객체를 찾아 Mock객체를 생성
        MockitoAnnotations.initMocks(this);

        when(demoService.view(anyLong())).thenReturn(
            new Demo(){ }
        );


        // when
        Demo result = demoController.demoView(seq);


        // than
        Assert.assertNotNull(result);
    }

    @Test
    public void testDoAnswer(){

        // Mock Annotations이 선언된 객체를 찾아 Mock객체를 생성
        MockitoAnnotations.initMocks(this);

        // 파라미터를 그대로 리턴하기 위한 구문
        doAnswer((Answer) invocation -> {
            Object arg0 = invocation.getArgument(0);
            long seq = (Long)arg0;

            Demo demo = new Demo();
            demo.setSeq(seq);
            demo.setName("단순색");
            demo.setAge(23);

            return demo;
        }).when(demoService).view(anyLong());

        // given
        long seq = 5;


        // when
        Demo result = demoController.demoView(seq);
        System.out.println("result : "+result.toString());


        // than
        Assert.assertNotNull(result);
    }

    @Test
    public void testDemoDoNoting() {

        Demo demo = mock(Demo.class);

        doNothing().when(demo).setSeq(1);
        demo.setSeq(2);

        verify(demo).setSeq(anyLong());
    }


    @Test
    public void testMockVerify(){

        Demo demo = mock(Demo.class);
        String name = "SIMPOLOR";
        demo.setName(name);

        // n번 호출했는지 체크
        verify(demo, times(1)).setName(any(String.class)); // success

        // 호출 안했는지 체크
        verify(demo, never()).getName(); // success
        verify(demo, never()).setName(eq("ETC")); // success
        // verify(p, never()).setName(eq("JDM")); // fail

        // 최소한 1번 이상 호출했는지 체크
        verify(demo, atLeastOnce()).setName(any(String.class)); // success

        // 2번 이하 호출 했는지 체크
        verify(demo, atMost(2)).setName(any(String.class)); // success

        // 2번 이상 호출 했는지 체크
        // verify(p, atLeast(2)).setName(any(String.class)); // fail

        // 지정된 시간(millis)안으로 메소드를 호출 했는지 체크
        verify(demo, timeout(100)).setName(any(String.class)); // success

        // 지정된 시간(millis)안으로 1번 이상 메소드를 호출 했는지 체크
        verify(demo, timeout(100).atLeast(1)).setName(any(String.class)); // success
    }

    @Test(expected=IllegalArgumentException.class)
    public void testDemoThrow() {

        long seq = 1;
        MockitoAnnotations.initMocks(this);

        doThrow(new IllegalArgumentException()).when(demoService).view(anyLong());
        // doThrow(new IllegalArgumentException()).when(student).setName(eq("JDM"));

        Demo result = demoController.demoView(seq);

        Assert.assertNotNull(result);
    }

}
