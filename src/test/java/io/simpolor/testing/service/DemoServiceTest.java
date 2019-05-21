package io.simpolor.testing.service;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import io.simpolor.testing.domain.Demo;
import io.simpolor.testing.repository.DemoRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import reflection.DemoReflection;

import java.util.Optional;

public class DemoServiceTest {

    private DemoRepository demoRepository = mock(DemoRepository.class);
    private DemoService demoService = new DemoService(demoRepository);

    @Test
    void testDemoTotalcount() {

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
    void testDemoView() {

        // given
        long seq = 1;

        Demo demoReflection = DemoReflection.exampleDemoResult(seq, "test", 19);
        Optional<Demo> spy = Optional.ofNullable(demoReflection);
        when(demoRepository.findById(anyLong())).thenReturn(spy);


        // when
        Demo demo = demoService.view(seq);


        // then
        Assert.assertNotNull(demo);
        Assert.assertEquals(1, demo.getSeq());

    }
}