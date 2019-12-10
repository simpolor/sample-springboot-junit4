package io.simpolor.testing.service;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import io.simpolor.testing.domain.Demo;
import io.simpolor.testing.repository.DemoRepository;
import org.junit.*;

import org.mockito.*;
import reflection.DemoReflection;

import java.util.Optional;

public class DemoServiceTest {

    @Mock
    private DemoRepository demoRepository;

    @InjectMocks
    private DemoService demoService;

    @Before
    public void initMocks() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testDemoTotalcount() {

        // given
        long totalcount = 3;
        when(demoService.totalcount()).thenReturn(totalcount);


        // when
        long result = demoService.totalcount();


        // then
        Assert.assertNotNull(result);
        Assert.assertEquals(3, result);
    }

    @Test
    public void testDemoView() {

        // given
        long seq = 1;

        Demo demo = DemoReflection.exampleDemoResult(seq, "test", 19);
        Optional<Demo> spy = Optional.ofNullable(demo);
        when(demoRepository.findById(anyLong())).thenReturn(spy);


        // when
        Demo result = demoService.view(seq);


        // then
        Assert.assertNotNull(result);
        Assert.assertEquals(1, result.getSeq());

    }

}