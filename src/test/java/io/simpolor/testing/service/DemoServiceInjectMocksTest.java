package io.simpolor.testing.service;

import io.simpolor.testing.repository.DemoRepository;
import org.junit.*;
import org.mockito.*;

import static org.mockito.Mockito.when;

public class DemoServiceInjectMocksTest {

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
        long reuturnValue = 3L;
        when(demoRepository.count()).thenReturn(reuturnValue);

        // when
        long result = demoService.totalcount();


        // then
        Assert.assertNotNull(result);
        Assert.assertEquals(3L, result);
    }
}