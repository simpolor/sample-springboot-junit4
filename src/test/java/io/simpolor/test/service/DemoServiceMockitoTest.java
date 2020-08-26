package io.simpolor.test.service;

import io.simpolor.test.domain.Demo;
import io.simpolor.test.repository.DemoRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import reflection.DemoReflection;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class DemoServiceMockitoTest {

    @Mock
    private DemoRepository demoRepository;

    @InjectMocks
    private DemoService demoService;

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