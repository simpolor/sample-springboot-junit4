package example.library;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.*;

import io.simpolor.test.domain.Demo;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.*;

import java.util.*;

public class MockitoTest {

    @Test
    public void testMockVerify(){

        Demo actual = mock(Demo.class);
        actual.setName("name");

        // n번 호출했는지 체크
        verify(actual, times(1)).setName(any(String.class)); // success

        // 호출 안했는지 체크
        verify(actual, never()).getName(); // success
        verify(actual, never()).setName(eq("ETC")); // success
        // verify(p, never()).setName(eq("JDM")); // fail

        // 최소한 1번 이상 호출했는지 체크
        verify(actual, atLeastOnce()).setName(any(String.class)); // success

        // 2번 이하 호출 했는지 체크
        verify(actual, atMost(2)).setName(any(String.class)); // success

        // 2번 이상 호출 했는지 체크
        // verify(p, atLeast(2)).setName(any(String.class)); // fail

        // 지정된 시간(millis)안으로 메소드를 호출 했는지 체크
        verify(actual, timeout(100)).setName(any(String.class)); // success

        // 지정된 시간(millis)안으로 1번 이상 메소드를 호출 했는지 체크
        verify(actual, timeout(100).atLeast(1)).setName(any(String.class)); // success
    }

    @Test
    public void testInOrder() {

        List<String> mock = mock(List.class);
        mock.add("first");
        mock.add("second");

        InOrder inOrder = inOrder(mock);

        inOrder.verify(mock).add("first");
        inOrder.verify(mock).add("second");

        // 위와 비교
        List<String> mock1 = mock(List.class);
        List<String> mock2 = mock(List.class);

        mock1.add("first");
        mock2.add("second");

        InOrder inOrders = inOrder(mock1, mock2);

        inOrders.verify(mock1).add("first");
        inOrders.verify(mock2).add("second");
    }

    @Test
    public void testChaining() {
        List<String> chainingMock = mock(List.class);

        when(chainingMock.get(anyInt()))
                .thenReturn("가")
                .thenReturn("나");
                //.thenThrow(new RuntimeException());

        System.out.println(chainingMock.get(0));
        System.out.println(chainingMock.get(1));
        System.out.println(chainingMock.get(2));
    }

    @Test
    public void testRealSpying() {
        List list = new LinkedList();
        List spy = spy(list);

        when(spy.size()).thenReturn(100); // stubbing

        spy.add("one");
        spy.add("two");

        System.out.println(spy.get(0)); // one
        System.out.println(spy.size()); // 100

        verify(spy).add("one");
        verify(spy).add("two");

        // Wrong use case
        // when(spy.get(10)).thenReturn("foo"); // IndexOutOfBoundsException

        // use doReturn() instead
        doReturn("foo").when(spy).get(0);
    }

    @Test
    public void testInvocation() {

        Map<String, String> mock = mock(Map.class);

        when(mock.get(anyString())).thenAnswer(
                invocation -> invocation.getArgument(0));

        Assert.assertEquals("someString", mock.get("someString"));
        Assert.assertEquals("anotherString", mock.get("anotherString"));
    }

    @Test
    public void testArgumentCaptor() {

        List mock = mock(List.class);
        mock.addAll(Arrays.asList("one", "two"));  // false

        ArgumentCaptor<List> argument = ArgumentCaptor.forClass(List.class);
        verify(mock).addAll(argument.capture());
        Assert.assertTrue(argument.getValue().size() == 2);
    }
}
