package io.simpolor.test.service;

import io.simpolor.test.domain.Demo;
import io.simpolor.test.repository.DemoRepository;
import org.junit.*;
import org.mockito.*;
import org.springframework.context.ApplicationEventPublisher;

import java.util.*;

import static org.mockito.Mockito.when;

public class DemoServiceInjectMocksTest {

    @Mock
    private ApplicationEventPublisher applicationEventPublisher;

    @Captor
    protected ArgumentCaptor<Object> publishEventCaptor;

    @Mock
    private DemoRepository demoRepository;

    @InjectMocks
    private DemoService demoService;

    /***
     * @Before Annotation이 동작하지 않은 이유
     * 1. class 앞에 public을 붙이지 않을 경우 동작하지 않음.
     * 2. jupiter.api.Test를 사용하면서 Junit4 Annotation을 사용할 경우
     * 3. JUnit4에서는 test할 method 앞에 public을 붙이지 않을 경우
     */
    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testDemoTotalcount() {

        // given
        long returnValue = 3L;
        when(demoRepository.count()).thenReturn(returnValue);

        // when
        long actual = demoService.totalcount();


        // then
        Assert.assertNotNull(actual);
        Assert.assertEquals(3L, actual);
    }

    @Test
    public void testDemoList() {

        // given
        List<Demo> list = new ArrayList<>();
        list.add(new Demo(1, "김영희", 17));
        list.add(new Demo(2, "김철수", 18));
        when(demoRepository.findAll()).thenReturn(list);


        // when
        List<Demo> actual = demoService.list();


        // then
        Assert.assertNotNull(actual);
        Assert.assertEquals(2L, actual.size());
    }


}