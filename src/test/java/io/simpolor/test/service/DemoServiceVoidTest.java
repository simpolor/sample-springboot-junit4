package io.simpolor.test.service;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class DemoServiceVoidTest {

    @Mock
    private DemoService demoService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testDemoVisit() {

        // given
        long visit = 3L;


        // when
        demoService.setVisit(visit);


        // then
        verify(demoService, times(1)).setVisit(anyLong()); // success

    }

    @Test
    public void testDemoCaptor() {

        // given
        long visit = 3L;


        // when
        demoService.setVisit(visit);


        // then
        ArgumentCaptor<Long> visitCapture = ArgumentCaptor.forClass(Long.class);
        verify(demoService, times(1)).setVisit(visitCapture.capture()); // success

        Assertions.assertThat(visitCapture.getValue()).isEqualTo(visit);
    }

}